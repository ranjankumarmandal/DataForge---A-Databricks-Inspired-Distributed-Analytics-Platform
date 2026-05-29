package com.ranjankumarmandal.distributed_execution_service.event;

import lombok.*;

@Data
@Builder
@NoArgsConstructor
@AllArgsConstructor
public class ExecutionJobEvent {

    private Long jobId;

    private String jobName;

    private String jobType;

    private String payload;
}