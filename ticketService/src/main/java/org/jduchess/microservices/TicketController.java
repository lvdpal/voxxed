package org.jduchess.microservices;

import org.jduchess.microservices.model.Event;
import org.jduchess.microservices.model.Ticket;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import javax.validation.constraints.NotNull;
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
        return ticketRepository.findByEvent(event);
    }

    @RequestMapping(value = "/addTickets", method = RequestMethod.POST)
    public void addTickets(@RequestBody List<Ticket> tickets) {
        ticketRepository.saveAll(tickets);
    }
}
