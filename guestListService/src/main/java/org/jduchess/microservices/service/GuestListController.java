package org.jduchess.microservices.service;

import org.jduchess.microservices.domain.Guest;
import org.jduchess.microservices.domain.GuestListEvent;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/guestList")
public class GuestListController {

    private GuestListEventRepository eventRepository;
    private GuestRepository guestRepository;

    public GuestListController(GuestListEventRepository eventRepository, GuestRepository guestRepository) {
        this.eventRepository = eventRepository;
        this.guestRepository = guestRepository;
    }

    @CrossOrigin
    @RequestMapping(value = "/getEvents", method = RequestMethod.GET)
    public List<GuestListEvent> getEvents() {
        return (List<GuestListEvent>)eventRepository.findAll();
    }

    @CrossOrigin
    @RequestMapping(value = "/getGuestsForEvent/{eventId}", method = RequestMethod.POST)
    public List<Guest> getGuestListForEvent(@PathVariable("eventId") Long eventId) {
        return guestRepository.findByEventId(eventId);
    }

}
