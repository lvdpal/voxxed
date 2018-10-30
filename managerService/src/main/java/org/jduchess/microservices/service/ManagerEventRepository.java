package org.jduchess.microservices.service;

import org.jduchess.microservices.domain.MangerEvent;
import org.springframework.data.repository.CrudRepository;

interface ManagerEventRepository extends CrudRepository<MangerEvent, Long> {
}
