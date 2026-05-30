package com.ranjankumarmandal.notebook_execution_service.entity;

import lombok.*;
import org.springframework.data.annotation.Id;
import org.springframework.data.relational.core.mapping.Table;

import java.time.Instant;

@Data
@Builder
@NoArgsConstructor
@AllArgsConstructor
@Table("notebooks")
public class NotebookEntity {

    @Id
    private Long id;

    private String name;

    private String description;

    private String ownerId;

    private Instant createdAt;

    private Instant updatedAt;
}