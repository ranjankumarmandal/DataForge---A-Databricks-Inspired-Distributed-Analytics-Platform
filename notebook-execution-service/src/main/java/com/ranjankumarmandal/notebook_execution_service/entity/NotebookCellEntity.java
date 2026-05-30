package com.ranjankumarmandal.notebook_execution_service.entity;

import lombok.*;
import org.springframework.data.annotation.Id;
import org.springframework.data.relational.core.mapping.Table;

@Data
@Builder
@NoArgsConstructor
@AllArgsConstructor
@Table("notebook_cells")
public class NotebookCellEntity {

    @Id
    private Long id;

    private Long notebookId;

    private Integer cellOrder;

    private String cellType;

    private String cellContent;
}