package org.example.profiles.mapper;

import org.example.profiles.model.TrustDto;
import org.example.profiles.repository.entity.TrustEntity;

public class TrustMapper implements IBaseMapper<TrustEntity, TrustDto> {

    @Override
    public TrustDto toDto(TrustEntity entity) {
        if (entity == null) {
            return null;
        }

        return TrustDto.builder()
            .userId(entity.getUserId())
            .trustId(entity.getTrustId())
            .score(entity.getScore())
            .abuseReports(entity.getAbuseReports())
            .createdAt(entity.getCreatedAt())
            .createdBy(entity.getCreatedBy())
            .updatedAt(entity.getUpdatedAt())
            .updatedBy(entity.getUpdatedBy())
            .build();
    }

    @Override
    public TrustEntity toDb(TrustDto dto) {
        if (dto == null) {
            return null;
        }

        TrustEntity entity = new TrustEntity();
        entity.setUserId(dto.getUserId());
        entity.setTrustId(dto.getTrustId());
        entity.setScore(dto.getScore());
        entity.setAbuseReports(dto.getAbuseReports());
        entity.setCreatedAt(dto.getCreatedAt());
        entity.setCreatedBy(dto.getCreatedBy());
        entity.setUpdatedAt(dto.getUpdatedAt());
        entity.setUpdatedBy(dto.getUpdatedBy());
        return entity;
    }
}
