package org.example.profiles.mapper;

import org.example.profiles.model.AddressDto;
import org.example.profiles.repository.entity.AddresseEntity;

public class AddressMapper implements IBaseMapper<AddresseEntity, AddressDto> {

    @Override
    public AddressDto toDto(AddresseEntity entity) {
        if (entity == null) {
            return null;
        }

        return AddressDto.builder()
            .addressLine1(entity.getLine1())
            .addressLine2(entity.getLine2())
            .postalCode(entity.getPostalCode())
            .State(entity.getState())
            .Country(entity.getCountry())
            .landMark(entity.getType()) // assuming `type` maps to landMark or adjust as needed
            .nickName(entity.getAddressId())
            .createdBy(entity.getCreatedBy())   // ✅ works now
            .createdAt(entity.getCreatedAt())
            .updatedBy(String.valueOf(entity.getUpdatedBy()))
            .updatedAt(entity.getUpdatedAt())
            // adjust mapping if needed
            .build();
    }

    @Override
    public AddresseEntity toDb(AddressDto dto) {
        if (dto == null) {
            return null;
        }

        AddresseEntity entity = new AddresseEntity();
        entity.setLine1(dto.getAddressLine1());
        entity.setLine2(dto.getAddressLine2());
        entity.setPostalCode(dto.getPostalCode());
        entity.setState(dto.getState());
        entity.setCountry(dto.getCountry());
        entity.setType(dto.getLandMark()); // assuming landMark maps to type
        entity.setAddressId(dto.getNickName()); // assuming nickName maps to addressId
        return entity;
    }
}