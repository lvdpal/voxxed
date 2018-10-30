package org.jduchess.microservices.domain;

import javax.persistence.*;

@Entity
public class EventDetail {
    @Id
    @GeneratedValue(strategy= GenerationType.AUTO)
    private Long id;

    @OneToOne
    private MarketingEvent marketingEvent;

    private Integer numberOfTickets;

    private String ranking;

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public MarketingEvent getMarketingEvent() {
        return marketingEvent;
    }

    public void setMarketingEvent(MarketingEvent marketingEvent) {
        this.marketingEvent = marketingEvent;
    }

    public Integer getNumberOfTickets() {
        return numberOfTickets;
    }

    public void setNumberOfTickets(Integer numberOfTickets) {
        this.numberOfTickets = numberOfTickets;
    }

    public String getRanking() {
        return ranking;
    }

    public void setRanking(String ranking) {
        this.ranking = ranking;
    }
}
