package com.ranjankumarmandal.notebook_execution_service.service;

import com.ranjankumarmandal.notebook_execution_service.dto.AddCellRequest;
import com.ranjankumarmandal.notebook_execution_service.dto.CreateNotebookRequest;
import com.ranjankumarmandal.notebook_execution_service.entity.NotebookCellEntity;
import com.ranjankumarmandal.notebook_execution_service.entity.NotebookEntity;
import com.ranjankumarmandal.notebook_execution_service.repository.NotebookCellRepository;
import com.ranjankumarmandal.notebook_execution_service.repository.NotebookRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import reactor.core.publisher.Mono;

import java.time.Instant;

@Service
@RequiredArgsConstructor
public class NotebookService {

    private final NotebookRepository notebookRepository;

    private final NotebookCellRepository notebookCellRepository;

    public Mono<NotebookEntity> createNotebook(
            CreateNotebookRequest request
    ) {

        NotebookEntity notebook =
                NotebookEntity.builder()
                        .name(request.getName())
                        .description(request.getDescription())
                        .ownerId(request.getOwnerId())
                        .createdAt(Instant.now())
                        .updatedAt(Instant.now())
                        .build();

        return notebookRepository.save(notebook);
    }

    public Mono<NotebookCellEntity> addCell(
            Long notebookId,
            AddCellRequest request
    ) {

        NotebookCellEntity cell =
                NotebookCellEntity.builder()
                        .notebookId(notebookId)
                        .cellOrder(request.getCellOrder())
                        .cellType(request.getCellType())
                        .cellContent(request.getCellContent())
                        .build();

        return notebookCellRepository.save(cell);
    }

    public Mono<NotebookEntity> getNotebook(
            Long notebookId
    ) {

        return notebookRepository.findById(notebookId);
    }
}