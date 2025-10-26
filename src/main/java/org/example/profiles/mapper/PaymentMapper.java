package org.example.profiles.mapper;

import org.example.profiles.model.PaymentDto;
import org.example.profiles.repository.entity.PaymentEntity;

public class PaymentMapper implements IBaseMapper<PaymentEntity, PaymentDto> {

    @Override
    public PaymentDto toDto(PaymentEntity entity) {
        if (entity == null) {
            return null;
        }

        return PaymentDto.builder()
            .userId(entity.getUserId())
            .paymentId(entity.getPaymentId())
            .type(entity.getType())
            .maskedNumber(entity.getMaskedNumber())
            .expiry(entity.getExpiry())
            // inherited audit fields from BaseEntity → BaseModel
            .createdBy(entity.getCreatedBy())
            .createdAt(entity.getCreatedAt())
            .updatedBy(entity.getUpdatedBy())
            .updatedAt(entity.getUpdatedAt())
            .build();
    }

    @Override
    public PaymentEntity toDb(PaymentDto dto) {
        if (dto == null) {
            return null;
        }

        PaymentEntity entity = new PaymentEntity();
        entity.setUserId(dto.getUserId());
        entity.setPaymentId(dto.getPaymentId());
        entity.setType(dto.getType());
        entity.setMaskedNumber(dto.getMaskedNumber());
        entity.setExpiry(dto.getExpiry());
        // inherited audit fields
        entity.setCreatedBy(dto.getCreatedBy());
        entity.setCreatedAt(dto.getCreatedAt());
        entity.setUpdatedBy(dto.getUpdatedBy());
        entity.setUpdatedAt(dto.getUpdatedAt());

        return entity;
    }
}

