package org.jduchess.microservices.service;

import org.jduchess.microservices.domain.Event;
import org.jduchess.microservices.domain.EventSeating;
import org.jduchess.microservices.domain.Location;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
public class ProgrammingController {
    private LocationRepository locationRepository;
    private EventRepository eventRepository;
    private EventSeatingRepository eventSeatingRepository;

    public ProgrammingController(LocationRepository locationRepository, EventRepository eventRepository,
                                 EventSeatingRepository eventSeatingRepository) {
        this.locationRepository = locationRepository;
        this.eventRepository = eventRepository;
        this.eventSeatingRepository = eventSeatingRepository;
    }

    @RequestMapping(value = "/getLocations", method = RequestMethod.GET)
    public List<Location> getLocations() {
        return (List<Location>) locationRepository.findAll();
    }

    @RequestMapping(value = "/addEvent", method = RequestMethod.POST)
    public Event addEvent(@RequestBody Event event) {
        return eventRepository.save(event);
    }

    @RequestMapping(value = "/addSeating", method = RequestMethod.POST)
    public EventSeating addSeating(@RequestBody EventSeating seating) {
        return eventSeatingRepository.save(seating);
    }
}
