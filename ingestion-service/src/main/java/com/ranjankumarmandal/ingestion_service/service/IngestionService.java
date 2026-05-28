package com.ranjankumarmandal.ingestion_service.service;

import com.ranjankumarmandal.ingestion_service.entity.IngestionJobEntity;
import com.ranjankumarmandal.ingestion_service.producer.IngestionEventProducer;
import com.ranjankumarmandal.ingestion_service.repository.IngestionJobRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.http.codec.multipart.FilePart;
import org.springframework.stereotype.Service;
import reactor.core.publisher.Mono;

import java.time.LocalDateTime;
import java.util.UUID;

@Service
@RequiredArgsConstructor
public class IngestionService {

    private final IngestionJobRepository repository;

    private final IngestionEventProducer producer;

    public Mono<IngestionJobEntity> ingestFile(
            String tenantId,
            String datasetName,
            FilePart filePart) {

        IngestionJobEntity entity = IngestionJobEntity.builder()
                .id(UUID.randomUUID())
                .tenantId(tenantId)
                .datasetName(datasetName)
                .fileName(filePart.filename())
                .status("UPLOADED")
                .createdAt(LocalDateTime.now())
                .build();

        return repository.save(entity)
                .doOnSuccess(saved -> {

                    String event =
                            "INGESTION_STARTED:" + saved.getId();

                    producer.publishIngestionEvent(event);
                });
    }
}