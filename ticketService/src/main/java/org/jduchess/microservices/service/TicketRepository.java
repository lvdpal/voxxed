package org.jduchess.microservices.service;

import org.jduchess.microservices.domain.Ticket;
import org.springframework.data.repository.CrudRepository;

import java.util.List;

public interface TicketRepository extends CrudRepository<Ticket, Long> {

    List<Ticket> findByEventId(Long eventId);
}
