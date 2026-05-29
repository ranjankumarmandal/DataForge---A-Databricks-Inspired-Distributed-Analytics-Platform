package com.ranjankumarmandal.distributed_execution_service.dto;

import lombok.Data;

@Data
public class CreateExecutionJobRequest {

    private String jobName;

    private String jobType;

    private String payload;
}