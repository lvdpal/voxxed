package org.jduchess.microservices;

import org.jduchess.microservices.model.Seller;
import org.springframework.web.bind.annotation.*;

import javax.validation.constraints.NotNull;
import java.util.List;
import java.util.Optional;

@RestController
public class SellerController {
    private SellerRepository sellerRepository;

    public SellerController(@NotNull SellerRepository sellerRepository) {
        this.sellerRepository = sellerRepository;
    }

    @RequestMapping(value = "/addSeller", method = RequestMethod.POST)
    public void addSeller(@RequestBody Seller seller) {
        sellerRepository.save(seller);
    }

    @RequestMapping(value = "/getSeller/{sellerId}", method = RequestMethod.GET)
    public Optional<Seller> getSeller(@PathVariable("sellerId") int sellerId) {
        return sellerRepository.findById(sellerId);
    }

    @RequestMapping(value="/getAllSellers", method = RequestMethod.GET)
    public List<Seller> getAllSellers() {
        return (List)sellerRepository.findAll();
    }

}
