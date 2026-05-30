package com.ranjankumarmandal.notebook_execution_service.controller;

import com.ranjankumarmandal.notebook_execution_service.dto.AddCellRequest;
import com.ranjankumarmandal.notebook_execution_service.dto.CreateNotebookRequest;
import com.ranjankumarmandal.notebook_execution_service.entity.NotebookCellEntity;
import com.ranjankumarmandal.notebook_execution_service.entity.NotebookEntity;
import com.ranjankumarmandal.notebook_execution_service.service.NotebookService;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.*;
import reactor.core.publisher.Mono;

@RestController
@RequestMapping("/api/v1/notebooks")
@RequiredArgsConstructor
public class NotebookController {

    private final NotebookService notebookService;

    @PostMapping
    public Mono<NotebookEntity> createNotebook(
            @RequestBody CreateNotebookRequest request
    ) {

        return notebookService.createNotebook(request);
    }

    @GetMapping("/{id}")
    public Mono<NotebookEntity> getNotebook(
            @PathVariable Long id
    ) {

        return notebookService.getNotebook(id);
    }

    @PostMapping("/{id}/cells")
    public Mono<NotebookCellEntity> addCell(
            @PathVariable Long id,
            @RequestBody AddCellRequest request
    ) {

        return notebookService.addCell(id, request);
    }
}