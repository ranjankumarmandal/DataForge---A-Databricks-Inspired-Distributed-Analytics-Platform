package com.ranjankumarmandal.distributed_execution_service.repository;

import com.ranjankumarmandal.distributed_execution_service.entity.ExecutionJobEntity;
import org.springframework.data.repository.reactive.ReactiveCrudRepository;

public interface ExecutionJobRepository
        extends ReactiveCrudRepository<
        ExecutionJobEntity,
        Long
        > {
}