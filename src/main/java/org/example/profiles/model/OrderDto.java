package org.example.profiles.model;

import lombok.Data;
import lombok.experimental.SuperBuilder;

import java.util.List;
import java.util.Map;

@Data
@SuperBuilder
public class OrderDto extends  BaseModel {

    private String userId;
    private String orderId;
    private String platform;
    private String status;
    private String timestamp;
    private List<Map<String, Object>> items;

}
