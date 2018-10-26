package org.jduchess.microservices;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import java.math.BigDecimal;

@Entity
public class SalesReport {
    @Id
    @GeneratedValue(strategy= GenerationType.AUTO)
    private int id;
    private Seller seller;
    private Event event;
    private int nrOfTicketsSold;
    private BigDecimal totalRevenue;

    public SalesReport(){}

    public SalesReport(Seller seller, Event event, int nrOfTicketsSold, BigDecimal totalRevenue) {
        this.seller = seller;
        this.event = event;
        this.nrOfTicketsSold = nrOfTicketsSold;
        this.totalRevenue = totalRevenue;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public Seller getSeller() {
        return seller;
    }

    public void setSeller(Seller seller) {
        this.seller = seller;
    }

    public Event getEvent() {
        return event;
    }

    public void setEvent(Event event) {
        this.event = event;
    }

    public int getNrOfTicketsSold() {
        return nrOfTicketsSold;
    }

    public void setNrOfTicketsSold(int nrOfTicketsSold) {
        this.nrOfTicketsSold = nrOfTicketsSold;
    }

    public BigDecimal getTotalRevenue() {
        return totalRevenue;
    }

    public void setTotalRevenue(BigDecimal totalRevenue) {
        this.totalRevenue = totalRevenue;
    }
}
