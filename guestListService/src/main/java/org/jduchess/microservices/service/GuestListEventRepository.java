package org.jduchess.microservices.service;

import org.jduchess.microservices.domain.GuestListEvent;
import org.springframework.data.repository.CrudRepository;

interface GuestListEventRepository extends CrudRepository<GuestListEvent, Long> {
}
