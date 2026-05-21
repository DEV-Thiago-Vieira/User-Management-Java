package com.francisco_thiago.user_management.controller;

import com.francisco_thiago.user_management.business.UserService;
import com.francisco_thiago.user_management.infrastructure.dto.DetailedUserResponseDTO;
import com.francisco_thiago.user_management.infrastructure.dto.UserRequestDTO;
import com.francisco_thiago.user_management.infrastructure.dto.UserResponseDTO;
import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.Parameter;
import io.swagger.v3.oas.annotations.responses.ApiResponse;
import io.swagger.v3.oas.annotations.responses.ApiResponses;
import io.swagger.v3.oas.annotations.tags.Tag;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;


@Tag(name = "Users", description = "Operations related to user management")
@RestController
@RequestMapping("/users")
@RequiredArgsConstructor
public class UserController {

    private final UserService userService;

    @Operation(summary = "Create user", description = "Creates a new user in the system")
    @ApiResponses({
            @ApiResponse(responseCode = "201", description = "User created successfully"),
            @ApiResponse(responseCode = "400", description = "Invalid request body")
    })
    @PostMapping
    public ResponseEntity<Void> saveUser(
            @Parameter(description = "User object to be created", required = true)
            @RequestBody UserRequestDTO user) {
        userService.saveUser(user);
        return ResponseEntity.status(HttpStatus.CREATED).build();
    }

    @Operation(summary = "Find user by id", description = "Returns a single user by its id.")
    @ApiResponses({
            @ApiResponse(responseCode = "200", description = "User found"),
            @ApiResponse(responseCode = "404", description = "User not found")
    })
    @GetMapping
    public ResponseEntity<DetailedUserResponseDTO> getUserByEmail(
            @Parameter(description = "Id of the user", example = "1", required = true)
            @RequestParam Long id) {
        return ResponseEntity.ok(userService.findById(id));
    }

    @Operation(summary = "Delete user by email", description = "Deletes the user that matches the given email")
    @ApiResponses({
            @ApiResponse(responseCode = "200", description = "User deleted successfully"),
            @ApiResponse(responseCode = "404", description = "User not found")
    })
    @DeleteMapping
    public ResponseEntity<Void> deleteUserByEmail(
            @Parameter(description = "Email address of the user to delete", example = "john@example.com", required = true)
            @RequestParam String email) {
        userService.deleteByEmail(email);
        return ResponseEntity.ok().build();
    }

    @Operation(summary = "Update user", description = "Updates an existing user identified by its ID")
    @ApiResponses({
            @ApiResponse(responseCode = "200", description = "User updated successfully"),
            @ApiResponse(responseCode = "400", description = "Invalid request body"),
            @ApiResponse(responseCode = "404", description = "User not found")
    })
    @PutMapping
    public ResponseEntity<Void> updateUser(
            @Parameter(description = "ID of the user to update", example = "1", required = true)
            @RequestParam Long id,
            @Parameter(description = "Updated user data", required = true)
            @RequestBody UserRequestDTO user) {
        userService.updateUser(id, user);
        return ResponseEntity.ok().build();
    }
}
