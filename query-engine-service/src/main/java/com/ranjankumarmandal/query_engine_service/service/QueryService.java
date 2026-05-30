package com.ranjankumarmandal.query_engine_service.service;

import com.ranjankumarmandal.query_engine_service.dto.QueryResponse;
import com.ranjankumarmandal.query_engine_service.dto.SubmitQueryRequest;
import com.ranjankumarmandal.query_engine_service.entity.QueryEntity;
import com.ranjankumarmandal.query_engine_service.repository.QueryRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import reactor.core.publisher.Mono;

import java.time.Instant;

@Service
@RequiredArgsConstructor
public class QueryService {

    private final QueryRepository queryRepository;

    public Mono<QueryResponse> submitQuery(
            SubmitQueryRequest request
    ) {

        QueryEntity query =
                QueryEntity.builder()
                        .queryText(request.getQueryText())
                        .queryType("SQL")
                        .status("SUBMITTED")
                        .submittedBy(request.getSubmittedBy())
                        .createdAt(Instant.now())
                        .build();

        return queryRepository.save(query)
                .map(saved ->
                        QueryResponse.builder()
                                .queryId(saved.getId())
                                .status(saved.getStatus())
                                .build()
                );
    }
}