package com.ranjankumarmandal.query_engine_service.entity;

import lombok.*;
import org.springframework.data.annotation.Id;
import org.springframework.data.relational.core.mapping.Table;

@Data
@Builder
@NoArgsConstructor
@AllArgsConstructor
@Table("query_results")
public class QueryResultEntity {

    @Id
    private Long id;

    private Long queryId;

    private String resultJson;
}