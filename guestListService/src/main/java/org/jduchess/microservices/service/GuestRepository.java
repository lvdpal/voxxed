package org.jduchess.microservices.service;

import org.jduchess.microservices.domain.Guest;
import org.springframework.data.repository.CrudRepository;

import java.util.List;

interface GuestRepository extends CrudRepository<Guest, Long> {
    List<Guest> findByEventId(Long eventId);
}
