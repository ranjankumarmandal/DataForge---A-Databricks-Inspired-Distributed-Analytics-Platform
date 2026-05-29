package com.ranjankumarmandal.stream_processing_service.pipeline;

import com.ranjankumarmandal.stream_processing_service.event.RawDataEvent;
import com.ranjankumarmandal.stream_processing_service.transform.EventTransformationService;
import com.ranjankumarmandal.stream_processing_service.validation.EventValidationService;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Component;
import reactor.core.publisher.Mono;

@Component
@RequiredArgsConstructor
public class EventPipeline {

    private final EventValidationService validationService;

    private final EventTransformationService transformationService;

    public Mono<RawDataEvent> process(
            RawDataEvent event
    ) {

        return validationService.validate(event)
                .flatMap(transformationService::transform);
    }
}