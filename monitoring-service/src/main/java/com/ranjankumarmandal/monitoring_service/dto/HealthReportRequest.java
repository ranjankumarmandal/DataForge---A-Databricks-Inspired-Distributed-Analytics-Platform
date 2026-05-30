package com.ranjankumarmandal.monitoring_service.dto;

import lombok.Data;

@Data
public class HealthReportRequest {

    private String serviceName;

    private String status;
}