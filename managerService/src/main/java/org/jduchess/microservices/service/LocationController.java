package org.jduchess.microservices.service;

import org.jduchess.microservices.domain.Location;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("/location")
public class LocationController {
    private LocationRepository locationRepository;

    public LocationController(LocationRepository locationRepository) {
        this.locationRepository = locationRepository;
    }

    @CrossOrigin
    @RequestMapping(value = "/addLocation", method = RequestMethod.POST)
    public Location addLocation(@RequestBody Location location) {
        return locationRepository.save(location);
    }

    @CrossOrigin
    @RequestMapping(value = "/getLocations", method = RequestMethod.GET)
    public List<Location> getLocations() {
        return (List<Location>) locationRepository.findAll();
    }

    @CrossOrigin
    @RequestMapping(value = "/updateLocation", method = RequestMethod.POST)
    public void updateLocation(@RequestBody Location location) {
        locationRepository.save(location);
    }

    @CrossOrigin
    @RequestMapping(value = "/deleteLocation/{locationId}", method = RequestMethod.DELETE)
    public boolean deleteLocation(@PathVariable("locationId") Long locationId) {
        System.out.println("I don't think I'll arrive here...");
        Optional<Location> location = locationRepository.findById(locationId);
        location.ifPresent(loc -> locationRepository.delete(loc));
        return true;
    }
}
