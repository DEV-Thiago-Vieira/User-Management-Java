package com.francisco_thiago.user_management.infrastructure.mapper;

import com.francisco_thiago.user_management.infrastructure.dto.TicketRequestDTO;
import com.francisco_thiago.user_management.infrastructure.dto.TicketResponseDTO;
import com.francisco_thiago.user_management.infrastructure.dto.UserRequestDTO;
import com.francisco_thiago.user_management.infrastructure.entity.Ticket;
import com.francisco_thiago.user_management.infrastructure.entity.User;
import org.mapstruct.Mapper;
import org.mapstruct.MappingConstants;

@Mapper(componentModel = MappingConstants.ComponentModel.SPRING)
public interface TicketMapper {
    Ticket toEntity(TicketRequestDTO ticketRequestDTO);
    TicketResponseDTO toDTO(Ticket ticket);
}
