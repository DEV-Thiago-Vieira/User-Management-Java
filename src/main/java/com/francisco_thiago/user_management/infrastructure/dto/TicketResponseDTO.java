package com.francisco_thiago.user_management.infrastructure.dto;

import io.swagger.v3.oas.annotations.media.Schema;

public record TicketResponseDTO(
		@Schema(description = "Ticket ID", example = "1")
		Long id,
		@Schema(description = "User data associated with the ticket")
		UserResponseDTO food,
		@Schema(description = "Food data associated with the ticket")
		FoodResponseDTO user
) {
}
