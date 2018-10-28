package org.jduchess.microservices;

import org.jduchess.microservices.model.Buyer;
import org.springframework.web.bind.annotation.*;

import javax.validation.constraints.NotNull;
import java.util.Optional;

@RestController
public class BuyerController {
    private BuyerRepository buyerRepository;

    public BuyerController(@NotNull BuyerRepository buyerRepository) {
        this.buyerRepository = buyerRepository;
    }

    @RequestMapping(value = "/addBuyer", method = RequestMethod.POST)
    public void addBuyer(@RequestBody Buyer buyer) {
        buyerRepository.save(buyer);
    }

    @RequestMapping(value = "/getBuyer/{buyerId}", method = RequestMethod.GET)
    public Optional<Buyer> getBuyer(@PathVariable("buyerId") int buyerId) {
        return buyerRepository.findById(buyerId);
    }
}
