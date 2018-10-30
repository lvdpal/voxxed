package org.jduchess.microservices.service;

import org.jduchess.microservices.domain.Location;
import org.springframework.data.repository.CrudRepository;

interface LocationRepository extends CrudRepository<Location, Long> {

}
