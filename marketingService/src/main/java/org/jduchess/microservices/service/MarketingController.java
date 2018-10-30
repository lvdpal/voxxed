package org.jduchess.microservices.service;

import org.jduchess.microservices.domain.MarketingEvent;
import org.jduchess.microservices.domain.EventDetail;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("/marketing")
public class MarketingController {
    private EventRepository eventRepository;
    private EventDetailRepository eventDetailRepository;

    public MarketingController(EventRepository eventRepository, EventDetailRepository eventDetailRepository) {
        this.eventRepository = eventRepository;
        this.eventDetailRepository = eventDetailRepository;
    }

    @CrossOrigin
    @RequestMapping(value = "/getEvents", method = RequestMethod.GET)
    public List<MarketingEvent> getEvents() {
        return (List<MarketingEvent>) eventRepository.findAll();
    }

    @CrossOrigin
    @RequestMapping(value = "/getEventDetailsForEvent/{eventId}", method = RequestMethod.POST)
    public Optional<EventDetail> getEventDetails(@PathVariable("eventId") Long eventId) {
        return eventDetailRepository.findByEventId(eventId);
    }

    // TODO determineDiscount
}
