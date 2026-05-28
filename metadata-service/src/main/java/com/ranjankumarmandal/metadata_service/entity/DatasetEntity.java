package com.ranjankumarmandal.metadata_service.entity;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.springframework.data.annotation.Id;
import org.springframework.data.relational.core.mapping.Table;

import java.time.LocalDateTime;
import java.util.UUID;

@Data
@Builder
@NoArgsConstructor
@AllArgsConstructor
@Table("datasets")
public class DatasetEntity {

    @Id
    private UUID id;

    private String tenantId;

    private String datasetName;

    private String datasetType;

    private String storagePath;

    private String schemaDefinition;

    private LocalDateTime createdAt;

    private LocalDateTime updatedAt;
}