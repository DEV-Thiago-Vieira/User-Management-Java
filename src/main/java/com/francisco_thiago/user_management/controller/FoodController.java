package com.francisco_thiago.user_management.controller;

import com.francisco_thiago.user_management.business.FoodService;
import com.francisco_thiago.user_management.infrastructure.entity.Food;
import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.Parameter;
import io.swagger.v3.oas.annotations.responses.ApiResponse;
import io.swagger.v3.oas.annotations.responses.ApiResponses;
import io.swagger.v3.oas.annotations.tags.Tag;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@Tag(name = "Foods", description = "Operations related to food management")
@RestController
@RequiredArgsConstructor
@RequestMapping("/foods")
public class FoodController {
    private final FoodService foodService;

    @Operation(summary = "List all foods", description = "Returns a list of all registered foods")
    @ApiResponses({
            @ApiResponse(responseCode = "200", description = "Foods retrieved successfully"),
            @ApiResponse(responseCode = "404", description = "No foods found")
    })
    @GetMapping
    public ResponseEntity<List<Food>> findAll() {
        return ResponseEntity.ok(foodService.findAll());
    }

    @Operation(summary = "Find food by ID", description = "Returns a single food item identified by its ID")
    @ApiResponses({
            @ApiResponse(responseCode = "200", description = "Food found"),
            @ApiResponse(responseCode = "404", description = "Food not found")
    })
    @GetMapping("/{id}")
    public ResponseEntity<Food> findById(
            @Parameter(description = "ID of the food to retrieve", example = "1", required = true)
            @PathVariable Long id) {
        return ResponseEntity.ok(foodService.findById(id));
    }

    @Operation(summary = "Create food", description = "Creates a new food item in the system")
    @ApiResponses({
            @ApiResponse(responseCode = "201", description = "Food created successfully"),
            @ApiResponse(responseCode = "400", description = "Invalid request body")
    })
    @PostMapping
    public ResponseEntity<Void> save(
            @Parameter(description = "Food object to be created", required = true)
            @RequestBody Food food) {
        foodService.save(food);
        return ResponseEntity.status(HttpStatus.CREATED).build();
    }

    @Operation(summary = "Update food", description = "Updates an existing food item identified by its ID")
    @ApiResponses({
            @ApiResponse(responseCode = "200", description = "Food updated successfully"),
            @ApiResponse(responseCode = "400", description = "Invalid request body"),
            @ApiResponse(responseCode = "404", description = "Food not found")
    })
    @PutMapping
    public ResponseEntity<Void> update(
            @Parameter(description = "ID of the food to update", example = "1", required = true)
            @RequestParam Long id,
            @Parameter(description = "Updated food data", required = true)
            @RequestBody Food food) {
        foodService.update(id, food);
        return ResponseEntity.ok().build();
    }

    @Operation(summary = "Delete food by ID", description = "Deletes the food item identified by its ID")
    @ApiResponses({
            @ApiResponse(responseCode = "200", description = "Food deleted successfully"),
            @ApiResponse(responseCode = "404", description = "Food not found")
    })
    @DeleteMapping("/{id}")
    public ResponseEntity<Void> deleteById(
            @Parameter(description = "ID of the food to delete", example = "1", required = true)
            @PathVariable Long id) {
        foodService.delete(id);
        return ResponseEntity.ok().build();
    }
}