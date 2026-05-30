package com.ranjankumarmandal.monitoring_service.entity;

import lombok.*;
import org.springframework.data.annotation.Id;
import org.springframework.data.relational.core.mapping.Table;

import java.time.Instant;

@Data
@Builder
@NoArgsConstructor
@AllArgsConstructor
@Table("service_metrics")
public class ServiceMetricEntity {

    @Id
    private Long id;

    private String serviceName;

    private String metricName;

    private Double metricValue;

    private Instant recordedAt;
}