package com.ranjankumarmandal.monitoring_service.entity;

import lombok.*;
import org.springframework.data.annotation.Id;
import org.springframework.data.relational.core.mapping.Table;

import java.time.Instant;

@Data
@Builder
@NoArgsConstructor
@AllArgsConstructor
@Table("monitored_services")
public class MonitoredServiceEntity {

    @Id
    private Long id;

    private String serviceName;

    private String status;

    private Instant lastCheckTime;
}