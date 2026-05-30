package com.ranjankumarmandal.query_engine_service.dto;

import lombok.Builder;
import lombok.Data;

@Data
@Builder
public class QueryResponse {

    private Long queryId;

    private String status;
}