package com.ranjankumarmandal.stream_processing_service.transform;

import com.ranjankumarmandal.stream_processing_service.event.RawDataEvent;
import org.springframework.stereotype.Service;
import reactor.core.publisher.Mono;

@Service
public class EventTransformationService {

    public Mono<RawDataEvent> transform(
            RawDataEvent event
    ) {

        event.getMetadata().put(
                "processedBy",
                "stream-processing-service"
        );

        return Mono.just(event);
    }
}