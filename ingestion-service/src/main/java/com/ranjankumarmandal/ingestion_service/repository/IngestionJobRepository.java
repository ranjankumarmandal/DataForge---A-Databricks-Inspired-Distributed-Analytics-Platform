package com.ranjankumarmandal.ingestion_service.repository;

import com.ranjankumarmandal.ingestion_service.entity.IngestionJobEntity;
import org.springframework.data.repository.reactive.ReactiveCrudRepository;

import java.util.UUID;

public interface IngestionJobRepository
        extends ReactiveCrudRepository<IngestionJobEntity, UUID> {
}