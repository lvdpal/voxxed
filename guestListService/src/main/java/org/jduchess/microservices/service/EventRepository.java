package org.jduchess.microservices.service;

import org.jduchess.microservices.domain.Event;
import org.springframework.data.repository.CrudRepository;

public interface EventRepository extends CrudRepository<Event, Long> {
}
