package org.jduchess.microservices.domain;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

@Entity
public class EventTicketInformation {
    @Id
    @GeneratedValue(strategy= GenerationType.AUTO)
    private Long id;

    private Event event;


}
