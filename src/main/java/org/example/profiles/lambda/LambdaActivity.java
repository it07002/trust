package org.example.profiles.lambda;

import com.fasterxml.jackson.databind.JsonNode;

public interface LambdaActivity<T> {
    T handleRequest(JsonNode input) throws Exception;
}
