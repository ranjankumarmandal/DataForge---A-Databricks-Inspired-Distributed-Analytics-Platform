package com.ranjankumarmandal.notebook_execution_service.dto;

import lombok.Data;

@Data
public class AddCellRequest {

    private Integer cellOrder;

    private String cellType;

    private String cellContent;
}