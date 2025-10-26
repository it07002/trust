package org.example.profiles.model;

import lombok.Builder;
import lombok.Data;
import lombok.experimental.SuperBuilder;

@Data
@SuperBuilder
public class AddressDto extends BaseModel {

    String addressLine1;
    String addressLine2;
    String postalCode;
    String State;
    String Country;
    String landMark;
    String nickName;

}
