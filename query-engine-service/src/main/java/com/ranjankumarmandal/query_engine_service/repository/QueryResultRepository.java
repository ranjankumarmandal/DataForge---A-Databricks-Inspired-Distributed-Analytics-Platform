package com.ranjankumarmandal.query_engine_service.repository;

import com.ranjankumarmandal.query_engine_service.entity.QueryResultEntity;
import org.springframework.data.repository.reactive.ReactiveCrudRepository;

public interface QueryResultRepository
        extends ReactiveCrudRepository<
        QueryResultEntity,
        Long
        > {
}