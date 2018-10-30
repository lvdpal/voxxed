package org.jduchess.microservices.service;

import org.jduchess.microservices.domain.Event;
import org.jduchess.microservices.domain.SalesReport;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("/reporting")
public class ReportingController {
    private EventRepository eventRepository;

    public ReportingController(EventRepository eventRepository, LocationRepository locationRepository) {
        this.eventRepository = eventRepository;
    }

    @CrossOrigin
    @RequestMapping(value = "/getEvents", method = RequestMethod.GET)
    public List<Event> getEvents() {
        return (List<Event>) eventRepository.findAll();
    }

    @CrossOrigin
    @RequestMapping(value = "/getSalesReportForEvent/{eventId}", method = RequestMethod.POST)
    public Optional<SalesReport> getSalesReportForEvent(@PathVariable("eventId") Long eventId) {
        // TODO implement generation of salesReport
        return Optional.empty();
    }

    @CrossOrigin
    @RequestMapping(value = "/getSalesReportForLocation/{locationId}", method = RequestMethod.POST)
    public Optional<SalesReport> getSalesReportForLocation(@PathVariable("locationId") Long locationId) {
        // TODO implement generation of salesReport
        return Optional.empty();
    }
}
