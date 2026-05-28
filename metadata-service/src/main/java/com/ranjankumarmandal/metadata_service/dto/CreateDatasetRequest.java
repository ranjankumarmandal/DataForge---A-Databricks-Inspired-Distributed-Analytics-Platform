package com.ranjankumarmandal.metadata_service.dto;

import jakarta.validation.constraints.NotBlank;
import lombok.Data;

@Data
public class CreateDatasetRequest {

    @NotBlank
    private String tenantId;

    @NotBlank
    private String datasetName;

    @NotBlank
    private String datasetType;

    private String storagePath;

    private String schemaDefinition;
}