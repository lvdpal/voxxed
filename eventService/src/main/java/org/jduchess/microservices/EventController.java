package org.jduchess.microservices;

import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import org.jduchess.microservices.model.Event;

import javax.validation.constraints.NotNull;
import java.util.List;
import java.util.Optional;

@RestController
public class EventController {
    private EventRepository eventRepository;

    public EventController(@NotNull EventRepository eventRepository) {
        this.eventRepository = eventRepository;
    }

    @RequestMapping(value = "/addEvent", method = RequestMethod.POST)
    public void addEvent(Event event) {
        eventRepository.save(event);
    }

    @RequestMapping(value = "/getEvent/{eventId}", method = RequestMethod.GET)
    public Optional<Event> getEvent(@PathVariable("eventId") int eventId) {
        return eventRepository.findById(eventId);
    }

    @RequestMapping(value="/getAllEvents", method = RequestMethod.GET)
    public List<Event> getAllEvents() {
        return (List)eventRepository.findAll();
    }
}
