package com.ranjankumarmandal.auth_service.entity;

import lombok.*;
import org.springframework.data.annotation.Id;
import org.springframework.data.relational.core.mapping.Table;

import java.time.Instant;

@Data
@Builder
@NoArgsConstructor
@AllArgsConstructor
@Table("users")
public class UserEntity {

    @Id
    private Long id;

    private String username;

    private String email;

    private String passwordHash;

    private String role;

    private String status;

    private Instant createdAt;

    private Instant updatedAt;
}