package org.example.profiles.mapper;

import org.example.profiles.model.OrderDto;
import org.example.profiles.repository.entity.OrderEntity;

public class OrderMapper implements IBaseMapper<OrderEntity, OrderDto> {

    @Override
    public OrderDto toDto(OrderEntity entity) {
        if (entity == null) {
            return null;
        }

        return OrderDto.builder()
            .userId(entity.getUserId())
            .orderId(entity.getOrderId())
            .platform(entity.getPlatform())
            .status(entity.getStatus())
            .timestamp(entity.getTimestamp())
            .items(entity.getItems())
            // inherited audit fields from BaseEntity → BaseModel
            .createdBy(entity.getCreatedBy())
            .createdAt(entity.getCreatedAt())
            .updatedBy(entity.getUpdatedBy())
            .updatedAt(entity.getUpdatedAt())
            .build();
    }

    @Override
    public OrderEntity toDb(OrderDto dto) {
        if (dto == null) {
            return null;
        }

        OrderEntity entity = new OrderEntity();
        entity.setUserId(dto.getUserId());
        entity.setOrderId(dto.getOrderId());
        entity.setPlatform(dto.getPlatform());
        entity.setStatus(dto.getStatus());
        entity.setTimestamp(dto.getTimestamp());
        entity.setItems(dto.getItems());
        // inherited audit fields
        entity.setCreatedBy(dto.getCreatedBy());
        entity.setCreatedAt(dto.getCreatedAt());
        entity.setUpdatedBy(dto.getUpdatedBy());
        entity.setUpdatedAt(dto.getUpdatedAt());

        return entity;
    }
}
