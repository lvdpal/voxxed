package microservices;

import org.jduchess.microservices.Seller;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RestController;

import java.util.Optional;

@RestController
public class SellerController {
    @Autowired
    private SellerRepository sellerRepository;

    public void addSeller(Seller seller) {
        sellerRepository.save(seller);
    }

    public Optional<Seller> getSeller(int id) {
        return sellerRepository.findById(id);
    }

}
