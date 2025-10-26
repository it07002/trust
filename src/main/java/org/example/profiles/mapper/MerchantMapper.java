package org.example.profiles.mapper;

import org.example.profiles.model.MerchantDto;
import org.example.profiles.repository.entity.MerchantEntity;

public class MerchantMapper implements IBaseMapper<MerchantEntity, MerchantDto> {

    @Override
    public MerchantDto toDto(MerchantEntity merchantEntity) {
        if (merchantEntity == null) {
            return null;
        }
        return MerchantDto.builder()
            .merchantId(merchantEntity.getMerchantId())
            .name(merchantEntity.getName())
            .email(merchantEntity.getContactEmail())
            .createdBy(merchantEntity.getCreatedBy())   // ✅ works now
            .createdAt(merchantEntity.getCreatedAt())
            .updatedBy(String.valueOf(merchantEntity.getUpdatedBy()))
            .updatedAt(merchantEntity.getUpdatedAt())
            .build();
    }

    @Override
    public MerchantEntity toDb(MerchantDto dto) {
        if (dto == null) {
            return null;
        }
        MerchantEntity merchantEntity = new MerchantEntity();
        merchantEntity.setMerchantId(dto.getMerchantId());
        merchantEntity.setName(dto.getName());
        merchantEntity.setContactEmail(dto.getEmail());
        merchantEntity.setCreatedAt(dto.getCreatedAt());
        merchantEntity.setCreatedBy(dto.getCreatedBy());
        merchantEntity.setUpdatedAt(dto.getUpdatedAt());
        merchantEntity.setUpdatedBy(dto.getUpdatedBy());
        return merchantEntity;
    }
}

