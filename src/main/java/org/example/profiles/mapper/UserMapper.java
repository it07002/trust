package org.example.profiles.mapper;

import org.example.profiles.model.UserDto;
import org.example.profiles.repository.entity.UserEntity;

public class UserMapper implements IBaseMapper<UserEntity, UserDto> {

    @Override
    public UserDto toDto(UserEntity entity) {
        if (entity == null) {
            return null;
        }

        return UserDto.builder()
            .userId(entity.getUserId())
            .core(entity.getCore())
            .attributes(entity.getAttributes())
            .createdBy(entity.getCreatedBy())   // ✅ works now
            .createdAt(entity.getCreatedAt())
            .updatedBy(entity.getUpdatedBy())
            .updatedAt(entity.getUpdatedAt())
            .build();
    }

    @Override
    public UserEntity toDb(UserDto dto) {
        if (dto == null) {
            return null;
        }

        UserEntity entity = new UserEntity();
        entity.setUserId(dto.getUserId());
        entity.setCore(dto.getCore());
        entity.setAttributes(dto.getAttributes());
        // Map audit fields from DTO if present
        entity.setCreatedBy(dto.getCreatedBy());
        entity.setCreatedAt(dto.getCreatedAt());
        entity.setUpdatedBy(dto.getUpdatedBy());
        entity.setUpdatedAt(dto.getUpdatedAt());
        return entity;
    }
}
