package com.francisco_thiago.user_management.infrastructure.repository;

import com.francisco_thiago.user_management.infrastructure.entity.Food;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.UUID;

public interface FoodRepository extends JpaRepository<Food, UUID> {
}
