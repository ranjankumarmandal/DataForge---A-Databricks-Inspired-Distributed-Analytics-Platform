package com.ranjankumarmandal.distributed_execution_service.producer;

import com.fasterxml.jackson.databind.ObjectMapper;
import com.ranjankumarmandal.distributed_execution_service.event.ExecutionJobEvent;
import lombok.RequiredArgsConstructor;
import org.apache.kafka.clients.producer.ProducerRecord;
import org.springframework.stereotype.Component;
import reactor.core.publisher.Mono;
import reactor.kafka.sender.KafkaSender;
import reactor.kafka.sender.SenderRecord;

@Component
@RequiredArgsConstructor
public class ExecutionJobProducer {

    private final KafkaSender<String, String> kafkaSender;

    private final ObjectMapper objectMapper;

    public Mono<Void> publishJob(
            ExecutionJobEvent event
    ) {

        try {

            String payload =
                    objectMapper.writeValueAsString(event);

            SenderRecord<String, String, String> record =
                    SenderRecord.create(
                            new ProducerRecord<>(
                                    "execution-jobs",
                                    event.getJobId().toString(),
                                    payload
                            ),
                            null
                    );

            return kafkaSender.send(Mono.just(record))
                    .then();

        } catch (Exception e) {

            return Mono.error(e);
        }
    }
}