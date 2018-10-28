package org.jduchess.microservices;

import org.springframework.data.repository.CrudRepository;
import org.jduchess.microservices.model.Address;

public interface AddressRepository extends CrudRepository<Address, Integer> {
}
