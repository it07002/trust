package org.example.profiles.handler;


import org.example.profiles.model.PaymentDto;
import java.util.List;

public interface IPaymentHandler {
    PaymentDto create(PaymentDto dto);
    PaymentDto getById(String paymentId);
    List<PaymentDto> getAll(String userId);
    PaymentDto update(PaymentDto dto);
    void delete(String paymentId);
}
