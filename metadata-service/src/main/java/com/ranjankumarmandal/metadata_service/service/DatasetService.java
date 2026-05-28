package com.ranjankumarmandal.metadata_service.service;

import com.ranjankumarmandal.metadata_service.dto.CreateDatasetRequest;
import com.ranjankumarmandal.metadata_service.entity.DatasetEntity;
import com.ranjankumarmandal.metadata_service.repository.DatasetRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import reactor.core.publisher.Flux;
import reactor.core.publisher.Mono;

import java.time.LocalDateTime;
import java.util.UUID;

@Service
@RequiredArgsConstructor
public class DatasetService {

    private final DatasetRepository datasetRepository;

    public Mono<DatasetEntity> createDataset(CreateDatasetRequest request) {

        DatasetEntity entity = DatasetEntity.builder()
                .id(UUID.randomUUID())
                .tenantId(request.getTenantId())
                .datasetName(request.getDatasetName())
                .datasetType(request.getDatasetType())
                .storagePath(request.getStoragePath())
                .schemaDefinition(request.getSchemaDefinition())
                .createdAt(LocalDateTime.now())
                .updatedAt(LocalDateTime.now())
                .build();

        return datasetRepository.save(entity);
    }

    public Flux<DatasetEntity> getDatasetsByTenant(String tenantId) {
        return datasetRepository.findByTenantId(tenantId);
    }
}