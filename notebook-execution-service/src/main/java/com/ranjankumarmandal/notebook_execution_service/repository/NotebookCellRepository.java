package com.ranjankumarmandal.notebook_execution_service.repository;

import com.ranjankumarmandal.notebook_execution_service.entity.NotebookCellEntity;
import org.springframework.data.repository.reactive.ReactiveCrudRepository;

public interface NotebookCellRepository
        extends ReactiveCrudRepository<
        NotebookCellEntity,
        Long
        > {
}