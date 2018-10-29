package org.jduchess.microservices.service;

import org.jduchess.microservices.domain.Event;
import org.jduchess.microservices.domain.Guest;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import java.util.Collections;
import java.util.List;

@RestController
public class GuestListController {

    private EventRepository eventRepository;
    private GuestRepository guestRepository;

    public GuestListController(EventRepository eventRepository, GuestRepository guestRepository) {
        this.eventRepository = eventRepository;
        this.guestRepository = guestRepository;
    }

    @RequestMapping(value = "/getEvents", method = RequestMethod.GET)
    public List<Event> getEvents() {
        return (List<Event>)eventRepository.findAll();
    }

    @RequestMapping(value = "/getGuestsForEvent/{eventId}", method = RequestMethod.POST)
    public List<Guest> getGuestListForEvent(@PathVariable("eventId") Long eventId) {
        return guestRepository.findByEventId(eventId);
    }

}
