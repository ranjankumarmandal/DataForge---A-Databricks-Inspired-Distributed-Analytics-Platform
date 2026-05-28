package com.ranjankumarmandal.ingestion_service.controller;

import com.ranjankumarmandal.ingestion_service.entity.IngestionJobEntity;
import com.ranjankumarmandal.ingestion_service.service.IngestionService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.MediaType;
import org.springframework.http.codec.multipart.FilePart;
import org.springframework.web.bind.annotation.*;
import reactor.core.publisher.Mono;

@RestController
@RequestMapping("/api/v1/ingestion")
@RequiredArgsConstructor
public class IngestionController {

    private final IngestionService ingestionService;

    @PostMapping(
            value = "/upload",
            consumes = MediaType.MULTIPART_FORM_DATA_VALUE
    )
    public Mono<IngestionJobEntity> uploadFile(
            @RequestPart("file") FilePart file,
            @RequestParam String tenantId,
            @RequestParam String datasetName) {

        return ingestionService.ingestFile(
                tenantId,
                datasetName,
                file
        );
    }
}