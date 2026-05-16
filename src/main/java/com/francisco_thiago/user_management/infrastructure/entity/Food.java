package com.francisco_thiago.user_management.infrastructure.entity;

import io.swagger.v3.oas.annotations.media.Schema;
import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@Entity
@Table(name = "food")
@Schema(description = "Represents a food item in the system")
public class Food {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    @Schema(description = "Unique identifier of the food item", example = "1", accessMode = Schema.AccessMode.READ_ONLY)
    private Long id;

    @Column(name = "name")
    @Schema(description = "Name of the food item", example = "Margherita Pizza")
    private String name;

    @Column(name = "price", length = 10, nullable = false)
    @Schema(description = "Price of the food item", example = "12.99")
    private Double price;
}
