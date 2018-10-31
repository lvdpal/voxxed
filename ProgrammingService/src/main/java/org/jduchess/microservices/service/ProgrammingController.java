package org.jduchess.microservices.service;

import org.jduchess.microservices.domain.Event;
import org.jduchess.microservices.domain.EventSeating;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("/programming")
public class ProgrammingController {
    private EventRepository eventRepository;
    private EventSeatingRepository eventSeatingRepository;

    public ProgrammingController(EventRepository eventRepository,
                                 EventSeatingRepository eventSeatingRepository) {
        this.eventRepository = eventRepository;
        this.eventSeatingRepository = eventSeatingRepository;
    }

    @CrossOrigin
    @RequestMapping(value = "/addEvent", method = RequestMethod.POST)
    public Event addEvent(@RequestBody Event event) {
        return eventRepository.save(event);
    }

    @CrossOrigin
    @RequestMapping(value = "/updateEvent", method = RequestMethod.POST)
    public Event updateEvent(@RequestBody Event event) {
        return eventRepository.save(event);
    }


    @CrossOrigin
    @RequestMapping(value = "/getEvents", method = RequestMethod.GET)
    public List<Event> getEvents() {
        return  (List<Event>) eventRepository.findAll();
    }

    @CrossOrigin
    @RequestMapping(value = "/deleteEvent/{eventId}", method = RequestMethod.DELETE)
    public boolean deleteEvent(@PathVariable("eventId") Long eventId) {
        Optional<Event> programmingEvent = eventRepository.findById(eventId);
        programmingEvent.ifPresent(event -> eventRepository.delete(event));
        return true;
    }

    @CrossOrigin
    @RequestMapping(value = "/addSeating", method = RequestMethod.POST)
    public EventSeating addSeating(@RequestBody EventSeating seating) {
        Optional<ProgrammingEvent> event = eventRepository.findById(seating.getProgrammingEvent().getId());
        if(event.isPresent()) {
            seating.setProgrammingEvent(event.get());
        }
        return eventSeatingRepository.save(seating);
    }
}
