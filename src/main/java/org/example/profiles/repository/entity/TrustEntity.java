package org.example.profiles.repository.entity;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import software.amazon.awssdk.enhanced.dynamodb.mapper.annotations.DynamoDbAttribute;
import software.amazon.awssdk.enhanced.dynamodb.mapper.annotations.DynamoDbBean;
import software.amazon.awssdk.enhanced.dynamodb.mapper.annotations.DynamoDbPartitionKey;
import software.amazon.awssdk.enhanced.dynamodb.mapper.annotations.DynamoDbSortKey;

/**
 * UserTrust entity for DynamoDB table (SDK v2 Enhanced Client)
 */
@Data
@NoArgsConstructor
@AllArgsConstructor
@DynamoDbBean
public class TrustEntity extends BaseEntity {

    private String userId;
    private String trustId;
    private Double score;
    private Integer abuseReports;

    @DynamoDbPartitionKey
    @DynamoDbAttribute("userId")
    public String getUserId() {
        return userId;
    }

    @DynamoDbSortKey
    @DynamoDbAttribute("trustId")
    public String getTrustId() {
        return trustId;
    }

    @DynamoDbAttribute("score")
    public Double getScore() {
        return score;
    }

    @DynamoDbAttribute("abuseReports")
    public Integer getAbuseReports() {
        return abuseReports;
    }

}
