package com.francisco_thiago.user_management.infrastructure.repository;

import com.francisco_thiago.user_management.infrastructure.entities.Food;
import org.springframework.data.jpa.repository.JpaRepository;

public interface FoodRepository extends JpaRepository<Food, Long> {
}
