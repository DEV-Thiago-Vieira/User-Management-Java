package com.francisco_thiago.user_management.infrastructure.entity;

import io.swagger.v3.oas.annotations.media.Schema;
import jakarta.persistence.*;
import lombok.*;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@Builder
@Table(name = "users")
@Entity
@Schema(description = "Represents a user in the system")
public class User {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    @Schema(description = "Unique identifier of the user", example = "1", accessMode = Schema.AccessMode.READ_ONLY)
    private Long id;

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
