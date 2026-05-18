package com.francisco_thiago.user_management.business;

import com.francisco_thiago.user_management.infrastructure.dto.*;
import com.francisco_thiago.user_management.infrastructure.entity.Food;
import com.francisco_thiago.user_management.infrastructure.entity.Ticket;
import com.francisco_thiago.user_management.infrastructure.entity.User;
import com.francisco_thiago.user_management.infrastructure.exception.ResourceNotFoundException;
import com.francisco_thiago.user_management.infrastructure.repository.TicketRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@RequiredArgsConstructor
public class TicketService {
    private final TicketRepository ticketRepository;
    private final UserService userService;
    private final FoodService foodService;

    public TicketResponseDTO findById(Long id) {
       return toResponseDTO(ticketRepository.findById(id).orElseThrow(() -> new ResourceNotFoundException("Ticket not found.")));
    }

    public List<TicketResponseDTO> findAllTickets() {
        return ticketRepository.findAll().stream().map(this::toResponseDTO).toList();
    }

    public void save(TicketRequestDTO ticketRequestDTO) {
        ticketRepository.save(toEntity(ticketRequestDTO));
    }

    public void update(TicketUpdateRequestDTO ticketUpdateRequestDTO) {
        Ticket ticket = ticketRepository.findById(ticketUpdateRequestDTO.id()).orElseThrow(() -> new ResourceNotFoundException(("Ticket not found.")));
        ticket.setUser(ticketUpdateRequestDTO.userId() != null ? userService.findById(ticketUpdateRequestDTO.userId()) : ticket.getUser());
        ticket.setFood(ticketUpdateRequestDTO.foodId() != null ? foodService.findById(ticketUpdateRequestDTO.foodId()) : ticket.getFood());
        ticketRepository.save(ticket);
    }

    public void delete(Long id) {
        ticketRepository.deleteById(id);
    }

    private TicketResponseDTO toResponseDTO(Ticket ticket) {
        UserResponseDTO userResponseDTO = new UserResponseDTO(
                ticket.getUser().getId(),
                ticket.getUser().getName()
        );

        FoodResponseDTO foodResponseDTO = new FoodResponseDTO(
                ticket.getFood().getId(),
                ticket.getFood().getName(),
                ticket.getFood().getPrice()
        );

        return new TicketResponseDTO(
                ticket.getId(),
                userResponseDTO,
                foodResponseDTO
        );
    }

    private Ticket toEntity(TicketRequestDTO ticketRequestDTO) {
        User user = userService.findById(ticketRequestDTO.userId());
        Food food = foodService.findById(ticketRequestDTO.foodId());
        return new Ticket(null, user, food);
    }
}