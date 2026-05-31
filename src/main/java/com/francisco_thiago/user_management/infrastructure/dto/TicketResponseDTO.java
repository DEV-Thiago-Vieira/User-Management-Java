package com.francisco_thiago.user_management.infrastructure.dto;

import io.swagger.v3.oas.annotations.media.Schema;

import java.util.UUID;

public record TicketResponseDTO(
		@Schema(description = "Ticket ID", example = "550e8400-e29b-41d4-a716-446655440002")
		UUID id,
		@Schema(description = "User data associated with the ticket")
		UserResponseDTO user,
		@Schema(description = "Food data associated with the ticket")
		FoodResponseDTO food
) {
}
