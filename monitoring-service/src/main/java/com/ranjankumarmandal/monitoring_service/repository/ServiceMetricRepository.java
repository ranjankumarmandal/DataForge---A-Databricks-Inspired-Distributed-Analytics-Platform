package com.ranjankumarmandal.monitoring_service.repository;

import com.ranjankumarmandal.monitoring_service.entity.ServiceMetricEntity;
import org.springframework.data.repository.reactive.ReactiveCrudRepository;

public interface ServiceMetricRepository
        extends ReactiveCrudRepository<
        ServiceMetricEntity,
        Long> {
}