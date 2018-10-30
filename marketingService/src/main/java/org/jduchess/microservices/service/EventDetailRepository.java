package org.jduchess.microservices.service;

import org.jduchess.microservices.domain.EventDetail;
import org.springframework.data.repository.CrudRepository;

import java.util.Optional;

interface EventDetailRepository extends CrudRepository<EventDetail, Long> {
    Optional<EventDetail> findByEventId(Long eventId);
}
