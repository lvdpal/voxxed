package org.jduchess.microservices.service;

import org.jduchess.microservices.domain.EventDetails;
import org.springframework.data.repository.CrudRepository;

interface EventDetailsRepository extends CrudRepository<EventDetails, Long> {
    EventDetails findByEventId(Long eventId);
}
