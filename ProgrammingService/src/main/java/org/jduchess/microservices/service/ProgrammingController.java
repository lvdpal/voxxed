package org.jduchess.microservices.service;

import org.jduchess.microservices.domain.ProgrammingEvent;
import org.jduchess.microservices.domain.EventSeating;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
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
    public ProgrammingEvent addEvent(@RequestBody ProgrammingEvent programmingEvent) {
        return eventRepository.save(programmingEvent);
    }

    @CrossOrigin
    @RequestMapping(value = "/updateEvent", method = RequestMethod.POST)
    public ProgrammingEvent updateEvent(@RequestBody ProgrammingEvent programmingEvent) {
        return eventRepository.save(programmingEvent);
    }


    @CrossOrigin
    @RequestMapping(value = "/getEvents", method = RequestMethod.GET)
    public List<ProgrammingEvent> getEvents() {
        List<ProgrammingEvent> list =  (List<ProgrammingEvent>) eventRepository.findAll();
        System.out.println("# of events: " + list.size());
        list.stream().forEach(l-> System.out.println(l.getId() + " " + l.getName() + " " + l.getLocation()));
        return list;
    }

    @CrossOrigin
    @RequestMapping(value = "/deleteEvent/{eventId}", method = RequestMethod.DELETE)
    public boolean deleteEvent(@PathVariable("eventId") Long eventId) {
        System.out.println("Delete event " +  eventId);
        Optional<ProgrammingEvent> programmingEvent = eventRepository.findById(eventId);
        if (programmingEvent.isPresent()) {
            eventRepository.delete(programmingEvent.get());
        }
        System.out.println("Event Deleted " + getEvents().size());
        return true;
    }

    @CrossOrigin
    @RequestMapping(value = "/addSeating", method = RequestMethod.POST)
    public EventSeating addSeating(@RequestBody EventSeating seating) {
        return eventSeatingRepository.save(seating);
    }
}
