package org.example.profiles.repository;


import jakarta.inject.Inject;
import jakarta.inject.Singleton;
import org.example.profiles.repository.entity.PaymentEntity;
import software.amazon.awssdk.enhanced.dynamodb.DynamoDbEnhancedClient;
import software.amazon.awssdk.enhanced.dynamodb.DynamoDbTable;
import software.amazon.awssdk.enhanced.dynamodb.TableSchema;

import java.util.List;
import java.util.Optional;

@Singleton
public class PaymentRepository {

    private final DynamoDbEnhancedClient dynamoDbClient;
    private final DynamoDbRepositoryHelper<PaymentEntity> helper;

    @Inject
    public PaymentRepository(DynamoDbEnhancedClient dynamoDbClient) {
        this.dynamoDbClient = dynamoDbClient;
        DynamoDbTable<PaymentEntity> table = dynamoDbClient.table("PaymentTable",
            TableSchema.fromBean(PaymentEntity.class));
        this.helper = new DynamoDbRepositoryHelper<>(table);
    }

    public void save(PaymentEntity entity) {
        helper.save(entity);
    }

    public Optional<PaymentEntity> findById(String paymentId) {
        return helper.findByGsi("PaymentIdIndex", paymentId);
    }

    public List<PaymentEntity> findAll(String userId) {
        return helper.findAllByPartitionKey(userId);
    }

    public void update(PaymentEntity entity) {
        helper.update(entity);
    }

    public void delete(String paymentId) {
        Optional<PaymentEntity> entityOpt = findById(paymentId);
        entityOpt.ifPresent(entity ->
            helper.deleteByKey(entity.getUserId(), entity.getPaymentId())
        );
    }
}



