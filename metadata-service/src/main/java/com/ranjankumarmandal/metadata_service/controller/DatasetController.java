package com.ranjankumarmandal.metadata_service.controller;

import com.ranjankumarmandal.metadata_service.dto.CreateDatasetRequest;
import com.ranjankumarmandal.metadata_service.entity.DatasetEntity;
import com.ranjankumarmandal.metadata_service.service.DatasetService;
import jakarta.validation.Valid;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.*;
import reactor.core.publisher.Flux;
import reactor.core.publisher.Mono;

@RestController
@RequestMapping("/api/v1/datasets")
@RequiredArgsConstructor
public class DatasetController {

    private final DatasetService datasetService;

    @PostMapping
    public Mono<DatasetEntity> createDataset(
            @Valid @RequestBody CreateDatasetRequest request) {

        return datasetService.createDataset(request);
    }

    @GetMapping("/{tenantId}")
    public Flux<DatasetEntity> getDatasetsByTenant(
            @PathVariable String tenantId) {

        return datasetService.getDatasetsByTenant(tenantId);
    }
}