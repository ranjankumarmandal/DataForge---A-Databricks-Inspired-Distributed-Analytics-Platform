package com.ranjankumarmandal.notebook_execution_service.dto;

import lombok.Data;

@Data
public class CreateNotebookRequest {

    private String name;

    private String description;

    private String ownerId;
}