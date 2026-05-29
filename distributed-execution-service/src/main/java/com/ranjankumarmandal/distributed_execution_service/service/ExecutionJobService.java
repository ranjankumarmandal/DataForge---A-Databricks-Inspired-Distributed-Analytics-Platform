package com.ranjankumarmandal.distributed_execution_service.service;

import com.ranjankumarmandal.distributed_execution_service.dto.CreateExecutionJobRequest;
import com.ranjankumarmandal.distributed_execution_service.entity.ExecutionJobEntity;
import com.ranjankumarmandal.distributed_execution_service.event.ExecutionJobEvent;
import com.ranjankumarmandal.distributed_execution_service.producer.ExecutionJobProducer;
import com.ranjankumarmandal.distributed_execution_service.repository.ExecutionJobRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import reactor.core.publisher.Mono;

@Service
@RequiredArgsConstructor
public class ExecutionJobService {

    private final ExecutionJobRepository repository;

    private final ExecutionJobProducer producer;

    public Mono<ExecutionJobEntity> submitJob(
            CreateExecutionJobRequest request
    ) {

        ExecutionJobEntity entity =
                ExecutionJobEntity.builder()
                        .jobName(request.getJobName())
                        .jobType(request.getJobType())
                        .payload(request.getPayload())
                        .status("SUBMITTED")
                        .build();

        return repository.save(entity)
                .flatMap(saved -> {

                    ExecutionJobEvent event =
                            ExecutionJobEvent.builder()
                                    .jobId(saved.getId())
                                    .jobName(saved.getJobName())
                                    .jobType(saved.getJobType())
                                    .payload(saved.getPayload())
                                    .build();

                    return producer.publishJob(event)
                            .thenReturn(saved);
                });
    }
}