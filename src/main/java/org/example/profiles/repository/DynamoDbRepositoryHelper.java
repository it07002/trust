package org.example.profiles.repository;

import lombok.extern.slf4j.Slf4j;
import software.amazon.awssdk.enhanced.dynamodb.DynamoDbTable;
import software.amazon.awssdk.enhanced.dynamodb.Key;
import software.amazon.awssdk.enhanced.dynamodb.model.QueryConditional;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

@Slf4j
public class DynamoDbRepositoryHelper<T> {

    private final DynamoDbTable<T> table;

    public DynamoDbRepositoryHelper(DynamoDbTable<T> table) {
        if (table == null) {
            throw new IllegalArgumentException("DynamoDbTable cannot be null");
        }
        this.table = table;
    }

    public void save(T entity) {
        if (entity == null) {
            log.warn("Attempted to save null entity");
            return;
        }
        log.debug("Saving entity: {}", entity);
        table.putItem(entity);
    }

    public void update(T entity) {
        if (entity == null) {
            log.warn("Attempted to update null entity");
            return;
        }
        log.debug("Updating entity: {}", entity);
        table.updateItem(entity);
    }

    public void deleteByKey(String partitionValue, String sortValue) {
        if (partitionValue == null || sortValue == null) {
            log.warn("Cannot delete entity with null key: partition={} sort={}", partitionValue, sortValue);
            return;
        }
        Key key = Key.builder()
            .partitionValue(partitionValue)
            .sortValue(sortValue)
            .build();
        log.debug("Deleting entity with key: {}", key);
        table.deleteItem(key);
    }

    public Optional<T> findByGsi(String indexName, String gsiPartitionValue) {
        if (indexName == null || gsiPartitionValue == null) {
            return Optional.empty();
        }

        var results = table.index(indexName)
            .query(QueryConditional.keyEqualTo(k -> k.partitionValue(gsiPartitionValue)));

        return results.stream()
            .flatMap(page -> page.items().stream())
            .findFirst();
    }

    public List<T> findAllByPartitionKey(String partitionValue) {
        if (partitionValue == null) {
            return List.of();
        }

        var results = table.query(QueryConditional.keyEqualTo(k -> k.partitionValue(partitionValue)));
        List<T> allItems = new ArrayList<>();
        results.stream().forEach(page -> allItems.addAll(page.items()));
        return List.copyOf(allItems); // return immutable list
    }
}
