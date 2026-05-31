package com.francisco_thiago.user_management.infrastructure.entity;

import io.swagger.v3.oas.annotations.media.Schema;
import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.math.BigDecimal;
import java.util.UUID;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@Entity
@Table(name = "food")
public class Food {

    @Id
    @GeneratedValue(strategy = GenerationType.UUID)
    @Schema(description = "Unique identifier of the food item", example = "550e8400-e29b-41d4-a716-446655440001", accessMode = Schema.AccessMode.READ_ONLY)
    private UUID id;

    @Column(name = "name")
    @Schema(description = "Name of the food item", example = "Margherita Pizza")
    private String name;

    @Column(name = "price", precision = 10, scale = 2, nullable = false)
    @Schema(description = "Price of the food item", example = "12.99")
    private BigDecimal price;
}
