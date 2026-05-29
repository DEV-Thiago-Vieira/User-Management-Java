package com.francisco_thiago.user_management.business;

import com.francisco_thiago.user_management.infrastructure.dto.FoodRequestDTO;
import com.francisco_thiago.user_management.infrastructure.dto.FoodResponseDTO;
import com.francisco_thiago.user_management.infrastructure.dto.UserRequestDTO;
import com.francisco_thiago.user_management.infrastructure.entity.Food;
import com.francisco_thiago.user_management.infrastructure.exception.ResourceNotFoundException;
import com.francisco_thiago.user_management.infrastructure.mapper.FoodMapper;
import com.francisco_thiago.user_management.infrastructure.repository.FoodRepository;
import jakarta.transaction.Transactional;
import lombok.RequiredArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@RequiredArgsConstructor
public class FoodService {
    private final FoodRepository foodRepository;
    @Autowired
    private final FoodMapper foodMapper;

    public List<FoodResponseDTO> findAll() {
        return foodRepository.findAll().stream().map(foodMapper::toDTO).toList();
    }

    public FoodResponseDTO findById(Long id) {
        return foodMapper.toDTO(foodRepository.findById(id).orElseThrow(() -> new ResourceNotFoundException("Food not found.")));
    }

    public void save(FoodRequestDTO food) {
        Food savedFood = new Food(null, food.name(), food.price());
        foodRepository.save(savedFood);
    }

    @Transactional
    public void update(Long id, FoodRequestDTO food) {
        Food oldFood = foodRepository.findById(id).orElseThrow(() -> new ResourceNotFoundException("Food not found."));
        Food updatedFood = new Food(
            oldFood.getId(),
            food.name() != null ? food.name() : oldFood.getName(),
            food.price() != null ? food.price() : oldFood.getPrice()
        );
        foodRepository.save(updatedFood);
    }

    @Transactional
    public void delete(Long id) {
        foodRepository.deleteById(id);
    }
}
