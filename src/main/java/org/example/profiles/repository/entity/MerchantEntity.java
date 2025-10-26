package org.example.profiles.repository.entity;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import software.amazon.awssdk.enhanced.dynamodb.mapper.annotations.DynamoDbBean;
import software.amazon.awssdk.enhanced.dynamodb.mapper.annotations.DynamoDbPartitionKey;

@Data
@NoArgsConstructor
@AllArgsConstructor
@DynamoDbBean
public class MerchantEntity extends  BaseEntity {

    private String merchantId;
    private String name;
    private String contactEmail;

    @DynamoDbPartitionKey
    public String getMerchantId() {
        return merchantId;
    }
}
