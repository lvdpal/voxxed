package org.jduchess.microservices;

import org.springframework.data.repository.CrudRepository;
import org.jduchess.microservices.model.Ticket;

public interface TicketRepository extends CrudRepository<Ticket, Integer> {
}
