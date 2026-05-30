package com.ranjankumarmandal.auth_service.controller;

import com.ranjankumarmandal.auth_service.dto.*;
import com.ranjankumarmandal.auth_service.entity.UserEntity;
import com.ranjankumarmandal.auth_service.service.AuthService;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.*;
import reactor.core.publisher.Mono;

@RestController
@RequestMapping("/api/v1/auth")
@RequiredArgsConstructor
public class AuthController {

    private final AuthService authService;

    @PostMapping("/register")
    public Mono<UserEntity> register(
            @RequestBody RegisterRequest request
    ) {
        return authService.register(request);
    }

    @PostMapping("/login")
    public Mono<LoginResponse> login(
            @RequestBody LoginRequest request
    ) {
        return authService.login(request);
    }
}