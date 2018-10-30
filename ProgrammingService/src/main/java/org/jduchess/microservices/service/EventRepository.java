package org.jduchess.microservices.service;

import org.jduchess.microservices.domain.Event;
import org.springframework.data.repository.CrudRepository;

interface EventRepository extends CrudRepository<Event, Long> {

}
