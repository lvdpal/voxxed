package microservices;

import org.jduchess.microservices.Seller;
import org.springframework.data.repository.CrudRepository;

public interface SellerRepository extends CrudRepository<Seller, Integer> {
}
