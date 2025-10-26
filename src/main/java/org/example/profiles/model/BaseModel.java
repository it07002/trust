package org.example.profiles.model;

import lombok.Builder;
import lombok.Data;
import lombok.experimental.SuperBuilder;

@Data
@SuperBuilder
@Builder
public class BaseModel {
    String createdBy;
    long createdAt;
    String updatedBy;
    long updatedAt;


}
