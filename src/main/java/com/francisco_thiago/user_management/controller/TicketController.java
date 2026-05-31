package com.francisco_thiago.user_management.controller;

import com.francisco_thiago.user_management.business.TicketService;
import com.francisco_thiago.user_management.infrastructure.dto.TicketRequestDTO;
import com.francisco_thiago.user_management.infrastructure.dto.TicketResponseDTO;
import com.francisco_thiago.user_management.infrastructure.dto.TicketUpdateRequestDTO;
import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.Parameter;
import io.swagger.v3.oas.annotations.responses.ApiResponse;
import io.swagger.v3.oas.annotations.responses.ApiResponses;
import io.swagger.v3.oas.annotations.tags.Tag;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.UUID;

@RequiredArgsConstructor
@RestController
@Tag(name = "Tickets", description = "Operations related to ticket management")
@RequestMapping("/ticket")
public class TicketController {

    private final TicketService ticketService;

    @Operation(summary = "List all tickets", description = "Returns a list of all registered tickets")
    @ApiResponses({
            @ApiResponse(responseCode = "200", description = "Tickets retrieved successfully")
    })
    @GetMapping
    public ResponseEntity<List<TicketResponseDTO>> findAll() {
        return ResponseEntity.ok(ticketService.findAllTickets());
    }

    @Operation(summary = "Find ticket by ID", description = "Returns a single ticket by ID")
    @ApiResponses({
            @ApiResponse(responseCode = "200", description = "Ticket found"),
            @ApiResponse(responseCode = "404", description = "Ticket not found")
    })
    @GetMapping("/{id}")
    public ResponseEntity<TicketResponseDTO> findById(
            @Parameter(description = "ID of the ticket to retrieve", example = "550e8400-e29b-41d4-a716-446655440002", required = true)
            @PathVariable UUID id) {
        return ResponseEntity.ok(ticketService.findById(id));
    }

    @Operation(summary = "Create ticket", description = "Creates a new ticket linking a user and a food")
    @ApiResponses({
            @ApiResponse(responseCode = "201", description = "Ticket created successfully"),
            @ApiResponse(responseCode = "400", description = "Invalid request body"),
            @ApiResponse(responseCode = "404", description = "User or food not found")
    })
    @PostMapping
    public ResponseEntity<Void> saveTicket(
            @Parameter(description = "Ticket data to be created", required = true)
            @RequestBody TicketRequestDTO ticketRequestDTO) {
        ticketService.save(ticketRequestDTO);
        return ResponseEntity.status(HttpStatus.CREATED).build();
    }

    @Operation(summary = "Update ticket", description = "Updates an existing ticket identified by its ID")
    @ApiResponses({
            @ApiResponse(responseCode = "200", description = "Ticket updated successfully"),
            @ApiResponse(responseCode = "400", description = "Invalid request body"),
            @ApiResponse(responseCode = "404", description = "Ticket, user, or food not found")
    })
    @PutMapping
    public ResponseEntity<Void> updateTicket(
            @Parameter(description = "Ticket update payload", required = true)
            @RequestBody TicketUpdateRequestDTO ticketUpdateRequestDTO) {
        ticketService.update(ticketUpdateRequestDTO);
        return ResponseEntity.ok().build();
    }

    @Operation(summary = "Delete ticket", description = "Deletes a ticket by its ID")
    @ApiResponses({
            @ApiResponse(responseCode = "200", description = "Ticket deleted successfully"),
            @ApiResponse(responseCode = "404", description = "Ticket not found")
    })
    @DeleteMapping("/{id}")
    public ResponseEntity<Void> deleteTicket(
            @Parameter(description = "ID of the ticket to delete", example = "550e8400-e29b-41d4-a716-446655440002", required = true)
            @PathVariable UUID id) {
        ticketService.delete(id);
        return ResponseEntity.ok().build();
    }
}
