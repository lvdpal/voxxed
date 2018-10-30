package org.jduchess.microservices.service;

import org.jduchess.microservices.domain.ProgrammingEvent;
import org.jduchess.microservices.domain.EventSeating;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

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
    public List<ProgrammingEvent> getEvents() { return (List<ProgrammingEvent>) eventRepository.findAll();}

    @CrossOrigin
    @RequestMapping(value = "/deleteEvent", method = RequestMethod.DELETE)
    public ResponseEntity deleteEvent(ProgrammingEvent programmingEvent) {
        eventRepository.delete(programmingEvent);
        return new ResponseEntity(null, HttpStatus.OK);
    }

    @CrossOrigin
    @RequestMapping(value = "/addSeating", method = RequestMethod.POST)
    public EventSeating addSeating(@RequestBody EventSeating seating) {
        return eventSeatingRepository.save(seating);
    }
}
