package org.jduchess.microservices;

import org.jduchess.microservices.model.Buyer;
import org.springframework.data.repository.CrudRepository;

public interface BuyerRepository extends CrudRepository<Buyer, Integer> {
}
