package org.jduchess.microservices;

import org.jduchess.microservices.model.Event;
import org.jduchess.microservices.model.Ticket;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
public class TicketController {


    @Autowired
    private TicketRepository ticketRepository;

    public void updateTicket(Ticket ticket) {
        ticketRepository.save(ticket);
    }

    public void updateTickets(List<Ticket> tickets) {
        ticketRepository.saveAll(tickets);
    }

    public List<Ticket> getTicketsForEvent(Event event) {
        return ticketRepository.findByEvent(event);
    }
}
