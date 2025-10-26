package org.example.profiles.repository.entity;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import software.amazon.awssdk.enhanced.dynamodb.mapper.annotations.DynamoDbAttribute;
import software.amazon.awssdk.enhanced.dynamodb.mapper.annotations.DynamoDbBean;
import software.amazon.awssdk.enhanced.dynamodb.mapper.annotations.DynamoDbPartitionKey;

import java.util.Map;

/**
 * Users entity for DynamoDB table (SDK v2 Enhanced Client)
 */
@Data
@NoArgsConstructor
@AllArgsConstructor
@DynamoDbBean
public class UserEntity extends BaseEntity {

    private String userId;
    private Map<String, Object> core;
    private Map<String, Object> attributes;

    @DynamoDbPartitionKey
    @DynamoDbAttribute("userId")
    public String getUserId() {
        return userId;
    }

    @DynamoDbAttribute("core")
    public Map<String, Object> getCore() {
        return core;
    }

    @DynamoDbAttribute("attributes")
    public Map<String, Object> getAttributes() {
        return attributes;
    }
}
