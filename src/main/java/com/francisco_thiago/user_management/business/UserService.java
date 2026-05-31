package com.francisco_thiago.user_management.business;

import com.francisco_thiago.user_management.infrastructure.dto.*;
import com.francisco_thiago.user_management.infrastructure.entity.User;
import com.francisco_thiago.user_management.infrastructure.exception.ResourceNotFoundException;
import com.francisco_thiago.user_management.infrastructure.mapper.UserMapper;
import com.francisco_thiago.user_management.infrastructure.repository.UserRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.UUID;

@Service
@RequiredArgsConstructor
public class UserService {

    private final UserRepository repository;

    private final UserMapper userMapper;

    public void saveUser(UserRequestDTO user) {
        User savedUser = userMapper.toEntity(user);
        repository.saveAndFlush(savedUser);
    }

    public DetailedUserResponseDTO findById(UUID id) {
        return userMapper.toDetailedDTO(repository.findById(id).orElseThrow(
                () -> new ResourceNotFoundException("User not found.")
        ));
    }

    public void deleteByEmail(String email) {
        repository.deleteByEmail(email);
    }

    public void updateUser(UUID id, UserRequestDTO user) {
        User oldUser = repository.findById(id).orElseThrow(
                () -> new RuntimeException("User not found.")
        );
        User updatedUser = User.builder()
                .id(oldUser.getId())
                .name(user.name() != null ? user.name() : oldUser.getName())
                .email(user.email() != null ? user.email() : oldUser.getEmail())
                .password(user.password() != null ? user.password() : oldUser.getPassword())
                .build();
        repository.saveAndFlush(updatedUser);
    }
}
