package com.francisco_thiago.user_management.controller;

import com.francisco_thiago.user_management.business.FoodService;
import com.francisco_thiago.user_management.infrastructure.entities.Food;
import lombok.RequiredArgsConstructor;
import org.apache.coyote.Response;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequiredArgsConstructor
@RequestMapping("/foods")
public class FoodController {
    private final FoodService foodService;

    @GetMapping
    public ResponseEntity<List<Food>> findAll() {
        return ResponseEntity.ok(foodService.findAll());
    }

    @GetMapping("/{id}")
    public ResponseEntity<Food> findById(@PathVariable Long id) {
        return ResponseEntity.ok(foodService.findById(id));
    }

    @PostMapping
    public ResponseEntity<Void> save(@RequestBody Food food) {
        foodService.save(food);
        return ResponseEntity.status(HttpStatus.CREATED).build();
    }

    @PutMapping
    public ResponseEntity<Void> update(@RequestParam Long id, @RequestBody Food food) {
        foodService.update(id, food);
        return ResponseEntity.ok().build();
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Void> deleteById(@PathVariable  Long id) {
        foodService.delete(id);
        return ResponseEntity.ok().build();
    }
}