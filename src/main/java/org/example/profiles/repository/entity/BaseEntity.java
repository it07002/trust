package org.example.profiles.repository.entity;



import lombok.Getter;
import lombok.Setter;
import lombok.ToString;
import software.amazon.awssdk.enhanced.dynamodb.mapper.annotations.DynamoDbAttribute;

/**
 * Common base entity for audit fields.
 */
@Getter
@Setter
@ToString
public abstract class BaseEntity {

    private String createdBy;
    private String updatedBy;
    private long createdAt;
    private long updatedAt;

    @DynamoDbAttribute("createdBy")
    public String getCreatedBy() {
        return createdBy;
    }

    @DynamoDbAttribute("updatedBy")
    public String getUpdatedBy() {
        return updatedBy;
    }

    @DynamoDbAttribute("createdAt")
    public long getCreatedAt() {
        return createdAt;
    }

    @DynamoDbAttribute("updatedAt")
    public long getUpdatedAt() {
        return updatedAt;
    }
}
