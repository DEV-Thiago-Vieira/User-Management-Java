package com.francisco_thiago.user_management.business;

import com.francisco_thiago.user_management.infrastructure.entity.User;
import com.francisco_thiago.user_management.infrastructure.exception.ResourceNotFoundException;
import com.francisco_thiago.user_management.infrastructure.repository.UserRepository;
import org.springframework.stereotype.Service;

@Service
public class UserService {

    private final UserRepository repository;

    public UserService(UserRepository repository) {
        this.repository = repository;
    }

    public void saveUser(User user) {
        repository.saveAndFlush(user);
    }

    public User findById(Long id) {
        return repository.findById(id).orElseThrow(
                () -> new ResourceNotFoundException("User not found.")
        );
    }

    public void deleteByEmail(String email) {
        repository.deleteByEmail(email);
    }

    public void updateUser(Long id, User user) {
        User oldUser = repository.findById(id).orElseThrow(
                () -> new RuntimeException("User not found.")
        );
        User updatedUser = User.builder()
                .id(oldUser.getId())
                .name(user.getName() != null ? user.getName() : oldUser.getName())
                .email(user.getEmail() != null ? user.getEmail() : oldUser.getEmail())
                .password(user.getPassword() != null ? user.getPassword() : oldUser.getPassword())
                .build();
        repository.saveAndFlush(updatedUser);
    }
}
