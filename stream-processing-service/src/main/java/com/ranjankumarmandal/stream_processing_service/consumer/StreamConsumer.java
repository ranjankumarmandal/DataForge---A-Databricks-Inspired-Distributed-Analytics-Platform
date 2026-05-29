package com.ranjankumarmandal.stream_processing_service.consumer;

import com.fasterxml.jackson.databind.ObjectMapper;
import com.ranjankumarmandal.stream_processing_service.event.RawDataEvent;
import com.ranjankumarmandal.stream_processing_service.pipeline.EventPipeline;
import jakarta.annotation.PostConstruct;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Component;
import reactor.kafka.receiver.KafkaReceiver;

@Slf4j
@Component
@RequiredArgsConstructor
public class StreamConsumer {

    private final KafkaReceiver<String, String> kafkaReceiver;

    private final ObjectMapper objectMapper;

    private final EventPipeline eventPipeline;

    @PostConstruct
    public void consume() {

        kafkaReceiver.receive()
                .flatMap(record -> {

                    try {

                        RawDataEvent event =
                                objectMapper.readValue(
                                        record.value(),
                                        RawDataEvent.class
                                );

                        return eventPipeline.process(event)
                                .doOnSuccess(processed -> {

                                    log.info(
                                            "Processed Event: {}",
                                            processed
                                    );

                                    record.receiverOffset()
                                            .acknowledge();
                                });

                    } catch (Exception e) {

                        log.error(
                                "Failed to process event",
                                e
                        );

                        return reactor.core.publisher.Mono.empty();
                    }
                })
                .subscribe();
    }
}