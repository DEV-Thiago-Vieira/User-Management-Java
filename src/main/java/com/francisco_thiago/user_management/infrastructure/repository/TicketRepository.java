package com.francisco_thiago.user_management.infrastructure.repository;

import com.francisco_thiago.user_management.infrastructure.entity.Ticket;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.UUID;

public interface TicketRepository extends JpaRepository<Ticket, UUID> {
}
