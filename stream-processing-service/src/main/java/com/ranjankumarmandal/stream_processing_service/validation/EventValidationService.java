package com.ranjankumarmandal.stream_processing_service.validation;

import com.ranjankumarmandal.stream_processing_service.event.RawDataEvent;
import org.springframework.stereotype.Service;
import reactor.core.publisher.Mono;

@Service
public class EventValidationService {

    public Mono<RawDataEvent> validate(
            RawDataEvent event
    ) {

        if (event.getDatasetId() == null) {
            return Mono.error(
                    new RuntimeException("DatasetId is missing")
            );
        }

        return Mono.just(event);
    }
}