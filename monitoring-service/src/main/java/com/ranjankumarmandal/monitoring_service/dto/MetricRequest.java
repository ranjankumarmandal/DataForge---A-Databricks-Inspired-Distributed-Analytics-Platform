package com.ranjankumarmandal.monitoring_service.dto;

import lombok.Data;

@Data
public class MetricRequest {

    private String serviceName;

    private String metricName;

    private Double metricValue;
}