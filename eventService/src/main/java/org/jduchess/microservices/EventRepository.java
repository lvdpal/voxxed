package org.jduchess.microservices;

import org.jduchess.microservices.model.Event;
import org.springframework.data.repository.CrudRepository;

public interface EventRepository extends CrudRepository<Event, Integer> {
}
