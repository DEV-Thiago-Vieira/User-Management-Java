package com.francisco_thiago.user_management.infrastructure.entity;

import io.swagger.v3.oas.annotations.media.Schema;
import jakarta.persistence.*;
import lombok.*;

import java.util.UUID;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@Builder
@Table(name = "users")
@Entity
public class User {

    @Id
    @GeneratedValue(strategy = GenerationType.UUID)
    @Schema(description = "Unique identifier of the user", example = "550e8400-e29b-41d4-a716-446655440000", accessMode = Schema.AccessMode.READ_ONLY)
    private UUID id;

    @Column(name = "email", unique = true)
    @Schema(description = "Email address of the user (must be unique)", example = "john@example.com")
    private String email;

    @Column(name = "name")
    @Schema(description = "Full name of the user", example = "John Doe")
    private String name;

    @Column(name = "password")
    @Schema(description = "Password of the user", example = "securePassword123")
    private String password;
}
