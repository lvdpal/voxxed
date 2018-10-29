package org.jduchess.microservices.service;

import org.jduchess.microservices.domain.Event;
import org.jduchess.microservices.domain.EventDetails;
import org.jduchess.microservices.domain.EventTicketInformation;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
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

    @RequestMapping(value = "/getEvents", method = RequestMethod.GET)
    public List<Event> getEvents() {
        return (List<Event>) eventRepository.findAll();
    }

    @RequestMapping(value = "/getEventDetails/{eventId}", method = RequestMethod.GET)
    public EventDetails getEventDetails(@PathVariable("eventId") Long eventId) {
        return eventDetailsRepository.findByEventId(eventId);
    }

    @RequestMapping(value = "/getEventTicketInformation/{eventId}", method = RequestMethod.GET)
    public EventTicketInformation getEventTicketInformation(@PathVariable("eventId")Long eventId) {
        return eventTicketInformationRepository.findByEventId(eventId);
    }
// buyTicket
// getTicketOverviewForCustomer
}
