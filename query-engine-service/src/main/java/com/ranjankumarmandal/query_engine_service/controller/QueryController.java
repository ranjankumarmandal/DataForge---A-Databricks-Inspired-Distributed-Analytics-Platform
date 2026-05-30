package com.ranjankumarmandal.query_engine_service.controller;

import com.ranjankumarmandal.query_engine_service.dto.QueryResponse;
import com.ranjankumarmandal.query_engine_service.dto.SubmitQueryRequest;
import com.ranjankumarmandal.query_engine_service.service.QueryService;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.*;
import reactor.core.publisher.Mono;

@RestController
@RequestMapping("/api/v1/query")
@RequiredArgsConstructor
public class QueryController {

    private final QueryService queryService;

    @PostMapping
    public Mono<QueryResponse> submitQuery(
            @RequestBody SubmitQueryRequest request
    ) {

        return queryService.submitQuery(request);
    }
}