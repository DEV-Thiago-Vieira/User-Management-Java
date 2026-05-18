package com.francisco_thiago.user_management.infrastructure.dto;

import io.swagger.v3.oas.annotations.media.Schema;

public record TicketRequestDTO(
		@Schema(description = "ID of the user linked to the ticket", example = "1", requiredMode = Schema.RequiredMode.REQUIRED)
		Long userId,
		@Schema(description = "ID of the food linked to the ticket", example = "2", requiredMode = Schema.RequiredMode.REQUIRED)
		Long foodId
) {
}
