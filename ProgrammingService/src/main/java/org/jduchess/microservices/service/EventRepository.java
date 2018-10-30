package org.jduchess.microservices.service;

import org.jduchess.microservices.domain.ProgrammingEvent;
import org.springframework.data.repository.CrudRepository;

interface EventRepository extends CrudRepository<ProgrammingEvent, Long> {

}
