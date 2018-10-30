package org.jduchess.microservices.service;

import org.jduchess.microservices.domain.Event;
import org.jduchess.microservices.domain.Guest;
import org.springframework.web.bind.annotation.*;

import java.util.Collections;
import java.util.List;

@RestController
@RequestMapping("/guestList")
public class GuestListController {

    private EventRepository eventRepository;
    private GuestRepository guestRepository;

    public GuestListController(EventRepository eventRepository, GuestRepository guestRepository) {
        this.eventRepository = eventRepository;
        this.guestRepository = guestRepository;
    }

    @CrossOrigin
    @RequestMapping(value = "/getEvents", method = RequestMethod.GET)
    public List<Event> getEvents() {
        return (List<Event>)eventRepository.findAll();
    }

    @CrossOrigin
    @RequestMapping(value = "/getGuestsForEvent/{eventId}", method = RequestMethod.POST)
    public List<Guest> getGuestListForEvent(@PathVariable("eventId") Long eventId) {
        return guestRepository.findByEventId(eventId);
    }

}
