package org.jduchess.microservices;

import java.math.BigDecimal;

public class SalesReport {
    private int id;
    private Seller seller;
    private Event event;
    private int nrOfTicketsSold;
    private BigDecimal totalRevenue;

    public SalesReport(){}

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
