package com.ranjankumarmandal.distributed_execution_service.controller;

import com.ranjankumarmandal.distributed_execution_service.dto.CreateExecutionJobRequest;
import com.ranjankumarmandal.distributed_execution_service.entity.ExecutionJobEntity;
import com.ranjankumarmandal.distributed_execution_service.service.ExecutionJobService;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.*;
import reactor.core.publisher.Mono;

@RestController
@RequestMapping("/api/v1/execution/jobs")
@RequiredArgsConstructor
public class ExecutionJobController {

    private final ExecutionJobService service;

    @PostMapping
    public Mono<ExecutionJobEntity> submitJob(
            @RequestBody CreateExecutionJobRequest request
    ) {

        return service.submitJob(request);
    }
}