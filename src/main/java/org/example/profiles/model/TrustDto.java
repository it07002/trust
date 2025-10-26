package org.example.profiles.model;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.experimental.SuperBuilder;

@Data
@SuperBuilder
public class TrustDto extends BaseModel {
    private String userId;
    private String trustId;
    private Double score;
    private Integer abuseReports;
}
