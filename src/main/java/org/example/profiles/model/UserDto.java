package org.example.profiles.model;

import lombok.Builder;
import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.experimental.SuperBuilder;

import java.util.Map;

@EqualsAndHashCode(callSuper = true)
@Data
@SuperBuilder
@Builder
public class UserDto extends BaseModel {
    private String userId;
    private Map<String, Object> core;
    private Map<String, Object> attributes;
}
