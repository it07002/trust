package org.example.profiles.mapper;


public interface IBaseMapper<DB, DTO> {
    DTO toDto(DB dbModel);
    DB toDb(DTO dto);
}
