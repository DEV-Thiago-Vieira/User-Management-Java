package com.francisco_thiago.user_management.business;

import com.francisco_thiago.user_management.infrastructure.dto.*;
import com.francisco_thiago.user_management.infrastructure.entity.Ticket;
import com.francisco_thiago.user_management.infrastructure.exception.ResourceNotFoundException;
import com.francisco_thiago.user_management.infrastructure.mapper.TicketMapper;
import com.francisco_thiago.user_management.infrastructure.repository.FoodRepository;
import com.francisco_thiago.user_management.infrastructure.repository.TicketRepository;
import com.francisco_thiago.user_management.infrastructure.repository.UserRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.UUID;

@Service
@RequiredArgsConstructor
public class TicketService {
    private final TicketRepository ticketRepository;
    private final UserRepository userRepository;
    private final FoodRepository foodRepository;

    private final TicketMapper ticketMapper;

    public TicketResponseDTO findById(UUID id) {
       return ticketMapper.toDTO(ticketRepository.findById(id).orElseThrow(() -> new ResourceNotFoundException("Ticket not found.")));
    }

    public List<TicketResponseDTO> findAllTickets() {
        return ticketRepository.findAll().stream().map(ticketMapper::toDTO).toList();
    }

    public void save(TicketRequestDTO ticketRequestDTO) {
        ticketRepository.save(ticketMapper.toEntity(ticketRequestDTO));
    }

    public void update(TicketUpdateRequestDTO ticketUpdateRequestDTO) {
        Ticket ticket = ticketRepository.findById(ticketUpdateRequestDTO.id()).orElseThrow(() -> new ResourceNotFoundException(("Ticket not found.")));
        ticket.setUser(ticketUpdateRequestDTO.userId() != null ? userRepository.findById(ticketUpdateRequestDTO.userId()).orElseThrow(() -> new ResourceNotFoundException("User not found.")) : ticket.getUser());
        ticket.setFood(ticketUpdateRequestDTO.foodId() != null ? foodRepository.findById(ticketUpdateRequestDTO.foodId()).orElseThrow(() -> new ResourceNotFoundException("Food not found.")) : ticket.getFood());
        ticketRepository.save(ticket);
    }

    public void delete(UUID id) {
        ticketRepository.deleteById(id);
    }
}