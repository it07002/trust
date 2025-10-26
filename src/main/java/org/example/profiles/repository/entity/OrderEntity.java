package org.example.profiles.repository.entity;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import software.amazon.awssdk.enhanced.dynamodb.mapper.annotations.DynamoDbBean;
import software.amazon.awssdk.enhanced.dynamodb.mapper.annotations.DynamoDbPartitionKey;
import software.amazon.awssdk.enhanced.dynamodb.mapper.annotations.DynamoDbSortKey;

import java.util.List;
import java.util.Map;

/**
 * Orders entity for DynamoDB table (SDK v2 Enhanced Client)
 */
@Data
@NoArgsConstructor
@AllArgsConstructor
@DynamoDbBean
public class OrderEntity extends  BaseEntity{

    private String userId;
    private String orderId;
    private String platform;
    private String status;
    private String timestamp;
    private List<Map<String, Object>> items;

    @DynamoDbPartitionKey
    public String getUserId() {
        return userId;
    }

    @DynamoDbSortKey
    public String getOrderId() {
        return orderId;
    }
}
