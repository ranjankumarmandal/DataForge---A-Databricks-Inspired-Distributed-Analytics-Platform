package com.ranjankumarmandal.auth_service.service;

import com.ranjankumarmandal.auth_service.dto.*;
import com.ranjankumarmandal.auth_service.entity.UserEntity;
import com.ranjankumarmandal.auth_service.repository.UserRepository;
import com.ranjankumarmandal.auth_service.security.JwtService;
import lombok.RequiredArgsConstructor;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.stereotype.Service;
import reactor.core.publisher.Mono;

import java.time.Instant;

@Service
@RequiredArgsConstructor
public class AuthService {

    private final UserRepository repository;

    private final BCryptPasswordEncoder encoder;

    private final JwtService jwtService;

    public Mono<UserEntity> register(
            RegisterRequest request
    ) {

        return repository.findByEmail(request.getEmail())
                .flatMap(user ->
                        Mono.error(
                                new RuntimeException(
                                        "Email already exists"
                                )
                        )
                )
                .switchIfEmpty(
                        repository.save(
                                UserEntity.builder()
                                        .username(request.getUsername())
                                        .email(request.getEmail())
                                        .passwordHash(
                                                encoder.encode(
                                                        request.getPassword()
                                                )
                                        )
                                        .role("DATA_ENGINEER")
                                        .status("ACTIVE")
                                        .createdAt(Instant.now())
                                        .updatedAt(Instant.now())
                                        .build()
                        )
                )
                .cast(UserEntity.class);
    }

    public Mono<LoginResponse> login(
            LoginRequest request
    ) {

        return repository.findByEmail(request.getEmail())
                .flatMap(user -> {

                    boolean valid =
                            encoder.matches(
                                    request.getPassword(),
                                    user.getPasswordHash()
                            );

                    if (!valid) {
                        return Mono.error(
                                new RuntimeException(
                                        "Invalid credentials"
                                )
                        );
                    }

                    String token =
                            jwtService.generateToken(
                                    user.getEmail(),
                                    user.getRole()
                            );

                    return Mono.just(
                            LoginResponse.builder()
                                    .accessToken(token)
                                    .tokenType("Bearer")
                                    .build()
                    );
                });
    }
}