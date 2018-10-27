package org.jduchess.microservices;

import org.jduchess.microservices.model.Seller;
import org.springframework.data.repository.CrudRepository;

public interface SellerRepository extends CrudRepository<Seller, Integer> {
}
