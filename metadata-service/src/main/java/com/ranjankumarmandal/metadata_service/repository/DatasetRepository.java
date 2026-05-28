package com.ranjankumarmandal.metadata_service.repository;

import com.ranjankumarmandal.metadata_service.entity.DatasetEntity;
import org.springframework.data.repository.reactive.ReactiveCrudRepository;
import reactor.core.publisher.Flux;

import java.util.UUID;

public interface DatasetRepository
        extends ReactiveCrudRepository<DatasetEntity, UUID> {

    Flux<DatasetEntity> findByTenantId(String tenantId);
}