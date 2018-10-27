package org.jduchess.microservices;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RestController;

import org.jduchess.microservices.model.Event;

import java.util.Optional;

@RestController
public class EventController {
    @Autowired
    private EventRepository eventRepository;

    public void addEvent(Event event) {
        eventRepository.save(event);
    }

    public Optional<Event> getEvent(int id) {
        return eventRepository.findById(id);
    }

}
