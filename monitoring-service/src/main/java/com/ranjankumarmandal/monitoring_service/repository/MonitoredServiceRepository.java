package com.ranjankumarmandal.monitoring_service.repository;

import com.ranjankumarmandal.monitoring_service.entity.MonitoredServiceEntity;
import org.springframework.data.repository.reactive.ReactiveCrudRepository;

public interface MonitoredServiceRepository
        extends ReactiveCrudRepository<
        MonitoredServiceEntity,
        Long> {
}