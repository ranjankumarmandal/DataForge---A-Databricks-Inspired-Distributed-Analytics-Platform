package com.ranjankumarmandal.monitoring_service.service;

import com.ranjankumarmandal.monitoring_service.dto.HealthReportRequest;
import com.ranjankumarmandal.monitoring_service.dto.MetricRequest;
import com.ranjankumarmandal.monitoring_service.entity.MonitoredServiceEntity;
import com.ranjankumarmandal.monitoring_service.entity.ServiceMetricEntity;
import com.ranjankumarmandal.monitoring_service.repository.MonitoredServiceRepository;
import com.ranjankumarmandal.monitoring_service.repository.ServiceMetricRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import reactor.core.publisher.Flux;
import reactor.core.publisher.Mono;

import java.time.Instant;

@Service
@RequiredArgsConstructor
public class MonitoringService {

    private final MonitoredServiceRepository serviceRepository;
    private final ServiceMetricRepository metricRepository;

    public Mono<MonitoredServiceEntity> reportHealth(
            HealthReportRequest request
    ) {

        MonitoredServiceEntity entity =
                MonitoredServiceEntity.builder()
                        .serviceName(request.getServiceName())
                        .status(request.getStatus())
                        .lastCheckTime(Instant.now())
                        .build();

        return serviceRepository.save(entity);
    }

    public Flux<MonitoredServiceEntity> getServices() {
        return serviceRepository.findAll();
    }

    public Mono<MonitoredServiceEntity> getService(
            Long id
    ) {
        return serviceRepository.findById(id);
    }

    public Mono<ServiceMetricEntity> saveMetric(
            MetricRequest request
    ) {

        ServiceMetricEntity metric =
                ServiceMetricEntity.builder()
                        .serviceName(request.getServiceName())
                        .metricName(request.getMetricName())
                        .metricValue(request.getMetricValue())
                        .recordedAt(Instant.now())
                        .build();

        return metricRepository.save(metric);
    }

    public Flux<ServiceMetricEntity> getMetrics() {
        return metricRepository.findAll();
    }
}