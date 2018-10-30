package org.jduchess.microservices.service;

import org.jduchess.microservices.domain.MarketingEvent;
import org.springframework.data.repository.CrudRepository;

interface EventRepository extends CrudRepository<MarketingEvent, Long> {
}
