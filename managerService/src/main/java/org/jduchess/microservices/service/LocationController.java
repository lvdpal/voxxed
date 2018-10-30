package org.jduchess.microservices.service;

import org.jduchess.microservices.domain.Location;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
public class LocationController {
    private LocationRepository locationRepository;

    public LocationController(LocationRepository locationRepository) {
        this.locationRepository = locationRepository;
    }

    @RequestMapping(value = "/addLocation", method = RequestMethod.POST)
    public Location addLocation(@RequestBody Location location) {
        return locationRepository.save(location);
    }

    @RequestMapping(value = "/getLocations", method = RequestMethod.GET)
    public List<Location> getLocations() {
        return (List<Location>) locationRepository.findAll();
    }

    @RequestMapping(value = "/updateLocation", method = RequestMethod.POST)
    public void updateLocation(@RequestBody Location location) {
        locationRepository.save(location);
    }

    @RequestMapping(value = "/deleteLocation", method = RequestMethod.POST)
    public void deleteLocation(@RequestBody Location location) {
        locationRepository.delete(location);
    }
}
