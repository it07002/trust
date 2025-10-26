package org.example.profiles.activity;

import jakarta.inject.Inject;
import jakarta.transaction.Transactional;
import jakarta.ws.rs.*;
import jakarta.ws.rs.core.MediaType;
import lombok.extern.slf4j.Slf4j;
import org.example.profiles.handler.impl.PaymentHandlerImpl;
import org.example.profiles.model.PaymentDto;

import java.util.List;

@Path("/payments")
@Produces(MediaType.APPLICATION_JSON)
@Consumes(MediaType.APPLICATION_JSON)
@Slf4j
public class PaymentActivity {

    private final PaymentHandlerImpl handler;

    @Inject
    public PaymentActivity(PaymentHandlerImpl handler) {
        this.handler = handler;
    }

    @POST
    @Transactional
    public PaymentDto createPayment(PaymentDto dto) {
        log.info("Creating payment for userId={} amount={}", dto.getPaymentId(), dto.getCreatedAt());
        return handler.create(dto);
    }

    @GET
    @Path("/{paymentId}")
    public PaymentDto getPayment(@PathParam("paymentId") String paymentId) {
        log.info("Fetching payment with ID={}", paymentId);
        PaymentDto payment = handler.getById(paymentId);
        if (payment == null) {
            log.warn("Payment with ID={} not found", paymentId);
            throw new NotFoundException("Payment with ID " + paymentId + " not found");
        }
        return payment;
    }

    @GET
    @Path("/user/{userId}")
    public List<PaymentDto> getPaymentsByUser(@PathParam("userId") String userId) {
        log.info("Fetching all payments for userId={}", userId);
        return handler.getAll(userId);
    }

    @PUT
    @Transactional
    public PaymentDto updatePayment(PaymentDto dto) {
        log.info("Updating payment ID={} for userId={}", dto.getPaymentId(), dto.getUserId());
        PaymentDto updated = handler.update(dto);
        if (updated == null) {
            log.warn("Payment with ID={} not found for update", dto.getPaymentId());
            throw new NotFoundException("Payment with ID " + dto.getPaymentId() + " not found for update");
        }
        return updated;
    }

    @DELETE
    @Path("/{paymentId}")
    @Transactional
    public void deletePayment(@PathParam("paymentId") String paymentId) {
        log.info("Deleting payment with ID={}", paymentId);
        handler.delete(paymentId);
    }
}
