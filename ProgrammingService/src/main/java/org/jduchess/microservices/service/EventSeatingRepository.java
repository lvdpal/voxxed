package org.jduchess.microservices.service;

import org.jduchess.microservices.domain.EventSeating;
import org.springframework.data.repository.CrudRepository;

interface EventSeatingRepository extends CrudRepository<EventSeating, Long> {
}
