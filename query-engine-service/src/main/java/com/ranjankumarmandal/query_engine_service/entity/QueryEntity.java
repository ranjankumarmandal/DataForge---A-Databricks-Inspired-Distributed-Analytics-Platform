package com.ranjankumarmandal.query_engine_service.entity;

import lombok.*;
import org.springframework.data.annotation.Id;
import org.springframework.data.relational.core.mapping.Table;

import java.time.Instant;

@Data
@Builder
@NoArgsConstructor
@AllArgsConstructor
@Table("queries")
public class QueryEntity {

    @Id
    private Long id;

    private String queryText;

    private String queryType;

    private String status;

    private String submittedBy;

    private Instant createdAt;

    private Instant completedAt;
}