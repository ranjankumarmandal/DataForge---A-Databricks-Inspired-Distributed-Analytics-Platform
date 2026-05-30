package com.ranjankumarmandal.monitoring_service.controller;

import com.ranjankumarmandal.monitoring_service.dto.HealthReportRequest;
import com.ranjankumarmandal.monitoring_service.dto.MetricRequest;
import com.ranjankumarmandal.monitoring_service.entity.MonitoredServiceEntity;
import com.ranjankumarmandal.monitoring_service.entity.ServiceMetricEntity;
import com.ranjankumarmandal.monitoring_service.service.MonitoringService;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.*;
import reactor.core.publisher.Flux;
import reactor.core.publisher.Mono;

@RestController
@RequestMapping("/api/v1")
@RequiredArgsConstructor
public class MonitoringController {

    private final MonitoringService monitoringService;

    @PostMapping("/health-report")
    public Mono<MonitoredServiceEntity> reportHealth(
            @RequestBody HealthReportRequest request
    ) {

        return monitoringService.reportHealth(request);
    }

    @GetMapping("/services")
    public Flux<MonitoredServiceEntity> getServices() {
        return monitoringService.getServices();
    }

    @GetMapping("/services/{id}")
    public Mono<MonitoredServiceEntity> getService(
            @PathVariable Long id
    ) {

        return monitoringService.getService(id);
    }

    @PostMapping("/metrics")
    public Mono<ServiceMetricEntity> saveMetric(
            @RequestBody MetricRequest request
    ) {

        return monitoringService.saveMetric(request);
    }

    @GetMapping("/metrics")
    public Flux<ServiceMetricEntity> getMetrics() {
        return monitoringService.getMetrics();
    }
}