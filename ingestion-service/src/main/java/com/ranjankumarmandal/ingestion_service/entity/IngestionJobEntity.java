package com.ranjankumarmandal.ingestion_service.entity;

import lombok.*;
import org.springframework.data.annotation.Id;
import org.springframework.data.relational.core.mapping.Table;

import java.time.LocalDateTime;
import java.util.UUID;

@Data
@Builder
@NoArgsConstructor
@AllArgsConstructor
@Table("ingestion_jobs")
public class IngestionJobEntity {

    @Id
    private UUID id;

    private String tenantId;

    private String datasetName;

    private String fileName;

    private String status;

    private LocalDateTime createdAt;
}