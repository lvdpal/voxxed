package org.jduchess.microservices.service;

import org.jduchess.microservices.domain.EventTicketInformation;
import org.springframework.data.repository.CrudRepository;

interface EventTicketInformationRepository extends CrudRepository<EventTicketInformation, Long> {
    EventTicketInformation findByEventId(Long eventId);
}
