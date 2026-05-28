package com.ranjankumarmandal.ingestion_service.producer;

import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.kafka.core.KafkaTemplate;
import org.springframework.stereotype.Component;

@Slf4j
@Component
@RequiredArgsConstructor
public class IngestionEventProducer {

    private final KafkaTemplate<String, String> kafkaTemplate;

    public void publishIngestionEvent(String event) {

        kafkaTemplate.send(
                "dataforge-ingestion-events",
                event
        );

        log.info("Published ingestion event: {}", event);
    }
}