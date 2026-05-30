package com.ranjankumarmandal.auth_service.repository;

import com.ranjankumarmandal.auth_service.entity.UserEntity;
import org.springframework.data.repository.reactive.ReactiveCrudRepository;
import reactor.core.publisher.Mono;

public interface UserRepository
        extends ReactiveCrudRepository<UserEntity, Long> {

    Mono<UserEntity> findByEmail(String email);
}