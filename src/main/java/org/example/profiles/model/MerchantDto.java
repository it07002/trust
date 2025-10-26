package org.example.profiles.model;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.NoArgsConstructor;
import lombok.experimental.SuperBuilder;

/**
 * Clean API-facing model (no DB annotations).
 */
@EqualsAndHashCode(callSuper = true)
@Data
@SuperBuilder
@Builder
public class MerchantDto extends BaseModel {
    private String merchantId;
    private String name;
    private String email;
}
