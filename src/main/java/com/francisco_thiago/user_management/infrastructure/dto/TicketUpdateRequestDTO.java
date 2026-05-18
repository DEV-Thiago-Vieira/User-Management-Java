package com.francisco_thiago.user_management.infrastructure.dto;

import io.swagger.v3.oas.annotations.media.Schema;

public record TicketUpdateRequestDTO(
		@Schema(description = "Ticket ID", example = "1", requiredMode = Schema.RequiredMode.REQUIRED)
		Long id,
		@Schema(description = "New user ID linked to the ticket", example = "3")
		Long userId,
		@Schema(description = "New food ID linked to the ticket", example = "4")
		Long foodId
) {
}
