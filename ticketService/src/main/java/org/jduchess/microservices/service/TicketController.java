package org.jduchess.microservices.service;

import org.jduchess.microservices.domain.Event;
import org.jduchess.microservices.domain.EventDetails;
import org.jduchess.microservices.domain.EventTicketInformation;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("ticket")
public class TicketController {
    private EventRepository eventRepository;
    private TicketRepository ticketRepository;
    private EventDetailsRepository eventDetailsRepository;
    private EventTicketInformationRepository eventTicketInformationRepository;

    public TicketController(EventRepository eventRepository, TicketRepository ticketRepository,
                            EventDetailsRepository eventDetailsRepository,
                            EventTicketInformationRepository eventTicketInformationRepository) {
        this.eventRepository = eventRepository;
        this.ticketRepository = ticketRepository;
        this.eventDetailsRepository = eventDetailsRepository;
        this.eventTicketInformationRepository = eventTicketInformationRepository;
    }

    @CrossOrigin
    @RequestMapping(value = "/getEvents", method = RequestMethod.GET)
    public List<Event> getEvents() {
        return (List<Event>) eventRepository.findAll();
    }

    @CrossOrigin
    @RequestMapping(value = "/getEventDetails/{eventId}", method = RequestMethod.GET)
    public EventDetails getEventDetails(@PathVariable("eventId") Long eventId) {
        return eventDetailsRepository.findByEventId(eventId);
    }

    @CrossOrigin
    @RequestMapping(value = "/getEventTicketInformation/{eventId}", method = RequestMethod.GET)
    public EventTicketInformation getEventTicketInformation(@PathVariable("eventId")Long eventId) {
        return eventTicketInformationRepository.findByEventId(eventId);
    }
// buyTicket
// getTicketOverviewForCustomer
}
