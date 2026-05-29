package com.ranjankumarmandal.distributed_execution_service.entity;

import lombok.*;
import org.springframework.data.annotation.Id;
import org.springframework.data.relational.core.mapping.Table;

@Data
@Builder
@NoArgsConstructor
@AllArgsConstructor
@Table("execution_jobs")
public class ExecutionJobEntity {

    @Id
    private Long id;

    private String jobName;

    private String jobType;

    private String payload;

    private String status;
}