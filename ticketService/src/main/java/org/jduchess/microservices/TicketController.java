package org.jduchess.microservices;

import org.jduchess.microservices.model.Event;
import org.jduchess.microservices.model.Ticket;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import javax.validation.constraints.NotNull;
import java.util.Collections;
import java.util.List;

@RestController
public class TicketController {

    private TicketRepository ticketRepository;

    public TicketController(@NotNull TicketRepository ticketRepository) {
        this.ticketRepository = ticketRepository;
    }

    @RequestMapping(value = "/updateTicket", method = RequestMethod.POST)
    public void updateTicket(@RequestBody Ticket ticket) {
        ticketRepository.save(ticket);
    }

    @RequestMapping(value = "/updateTickets", method = RequestMethod.POST)
    public void updateTickets(@RequestBody List<Ticket> tickets) {
        ticketRepository.saveAll(tickets);
    }

    @RequestMapping(value = "/ticketsForEvent", method = RequestMethod.POST)
    public List<Ticket> getTicketsForEvent(@RequestBody Event event) {
        if (event.getId()==-1) {
            return Collections.emptyList();
        }
        return ticketRepository.findByEventId(event.getId());
    }

    @RequestMapping(value = "/addTickets", method = RequestMethod.POST)
    public void addTickets(@RequestBody List<Ticket> tickets) {
        ticketRepository.saveAll(tickets);
    }
}
