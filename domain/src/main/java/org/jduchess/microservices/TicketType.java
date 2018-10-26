package org.jduchess.microservices;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import java.math.BigDecimal;

@Entity
public class TicketType {
    @Id
    @GeneratedValue(strategy= GenerationType.AUTO)
    private int id;
    private BigDecimal discountPercentage;
    private Type type;
    private String name;
}
