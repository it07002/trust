package org.example.profiles.model;

import lombok.Data;
import lombok.experimental.SuperBuilder;

@Data
@SuperBuilder
public class PaymentDto extends BaseModel{

    private String userId;
    private String paymentId;
    private String type;
    private String maskedNumber;
    private String expiry;
}
