package com.ranjankumarmandal.notebook_execution_service.repository;

import com.ranjankumarmandal.notebook_execution_service.entity.NotebookEntity;
import org.springframework.data.repository.reactive.ReactiveCrudRepository;

public interface NotebookRepository
        extends ReactiveCrudRepository<
        NotebookEntity,
        Long
        > {
}