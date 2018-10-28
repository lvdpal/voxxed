package org.jduchess.microservices;

import org.springframework.data.repository.CrudRepository;
import org.jduchess.microservices.model.Ticket;

import java.util.List;

public interface TicketRepository extends CrudRepository<Ticket, Integer> {

    List<Ticket> findByEventId(Integer eventId);
}
