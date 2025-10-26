
package org.example.profiles.handler.impl;

import jakarta.enterprise.context.ApplicationScoped;
import lombok.RequiredArgsConstructor;
import org.example.profiles.handler.IPaymentHandler;
import org.example.profiles.mapper.PaymentMapper;
import org.example.profiles.model.PaymentDto;
import org.example.profiles.repository.PaymentRepository;
import org.example.profiles.repository.entity.PaymentEntity;


import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

@ApplicationScoped
@RequiredArgsConstructor
public class PaymentHandlerImpl implements IPaymentHandler {

    private final PaymentRepository repository;
    private final PaymentMapper mapper = new PaymentMapper();


    @Override
    public PaymentDto create(PaymentDto dto) {
        PaymentEntity entity = mapper.toDb(dto);
        repository.save(entity);
        return mapper.toDto(entity);
    }

    @Override
    public PaymentDto getById(String paymentId) {
        Optional<PaymentEntity> entity = repository.findById(paymentId);
        return mapper.toDto(entity.get());
    }

    @Override
    public List<PaymentDto> getAll(String userId) {
        return repository.findAll(userId).stream()
            .map(mapper::toDto)
            .collect(Collectors.toList());
    }

    @Override
    public PaymentDto update(PaymentDto dto) {
        PaymentEntity entity = mapper.toDb(dto);
        repository.update(entity);
        return mapper.toDto(entity);
    }

    @Override
    public void delete(String paymentId) {
        repository.delete(paymentId);
    }
}
