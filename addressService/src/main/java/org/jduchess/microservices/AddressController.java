package org.jduchess.microservices;

import org.jduchess.microservices.model.Address;
import org.springframework.web.bind.annotation.*;

import javax.validation.constraints.NotNull;
import java.util.Optional;

@RestController
public class AddressController {
    private AddressRepository addressRepository;
    public AddressController(@NotNull AddressRepository addressRepository) {
        this.addressRepository = addressRepository;
    }

    @RequestMapping(value = "/addAddress", method = RequestMethod.POST)
    public void addAddress(@RequestBody Address address) {
        addressRepository.save(address);
    }

    @RequestMapping(value = "/getAddress/{addressId}", method = RequestMethod.GET)
    public Optional<Address> getAddress(@PathVariable("addressId") int addressId) {
        return addressRepository.findById(addressId);
    }
}
