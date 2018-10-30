package org.jduchess.microservices.service;

import org.jduchess.microservices.domain.Event;
import org.jduchess.microservices.domain.Location;
import org.jduchess.microservices.domain.SalesReport;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;
import java.util.Optional;

@RestController
public class ReportingController {
    private EventRepository eventRepository;
    private LocationRepository locationRepository;

    public ReportingController(EventRepository eventRepository, LocationRepository locationRepository) {
        this.eventRepository = eventRepository;
        this.locationRepository = locationRepository;
    }

    @RequestMapping(value = "/getEvents", method = RequestMethod.GET)
    public List<Event> getEvents() {
        return (List<Event>) eventRepository.findAll();
    }

    @RequestMapping(value = "/getLocations", method = RequestMethod.GET)
    public List<Location> getLocations() {
        return (List<Location>) locationRepository.findAll();
    }

    @RequestMapping(value = "/getSalesReportForEvent/{eventId}", method = RequestMethod.POST)
    public Optional<SalesReport> getSalesReportForEvent(@PathVariable("eventId") Long eventId) {
        // TODO implement generation of salesReport
        return Optional.empty();
    }

    @RequestMapping(value = "/getSalesReportForLocation/{locationId}", method = RequestMethod.POST)
    public Optional<SalesReport> getSalesReportForLocation(@PathVariable("locationId") Long locationId) {
        // TODO implement generation of salesReport
        return Optional.empty();
    }
}
