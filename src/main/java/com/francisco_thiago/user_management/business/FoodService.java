package com.francisco_thiago.user_management.business;

import com.francisco_thiago.user_management.infrastructure.entities.Food;
import com.francisco_thiago.user_management.infrastructure.repository.FoodRepository;
import jakarta.transaction.Transactional;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@RequiredArgsConstructor
public class FoodService {
    private final FoodRepository foodRepository;


    public List<Food> findAll() {
        return foodRepository.findAll();
    }

    public Food findById(Long id) {
        return foodRepository.findById(id).orElseThrow(() -> new RuntimeException("Food not found."));
    }

    public void save(Food food) {
        foodRepository.save(food);
    }

    @Transactional
    public void update(Long id, Food food) {
        Food oldFood = findById(id);
        Food updatedFood = new Food(
            oldFood.getId(),
            food.getName() != null ? food.getName() : oldFood.getName(),
            food.getPrice() != null ? food.getPrice() : oldFood.getPrice()
        );
        foodRepository.save(updatedFood);
    }

    @Transactional
    public void delete(Long id) {
        foodRepository.deleteById(id);
    }
}
