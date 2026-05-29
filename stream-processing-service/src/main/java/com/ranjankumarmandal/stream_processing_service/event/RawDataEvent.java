package com.ranjankumarmandal.stream_processing_service.event;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.time.Instant;
import java.util.Map;

@Data
@Builder
@NoArgsConstructor
@AllArgsConstructor
public class RawDataEvent {

    private String eventId;

    private String datasetId;

    private String source;

    private Instant timestamp;

    private Map<String, Object> payload;

    private Map<String, Object> metadata;
}