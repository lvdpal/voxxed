package org.jduchess.microservices.domain;

import javax.persistence.*;

@Entity
public class EventSeating {
    @Id
    @GeneratedValue(strategy= GenerationType.AUTO)
    private Long id;

    @Column(name = "event_id")
    private Long eventId;

    private String rank;
    private Integer amountOfSeats;

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public Long getEventId() {
        return eventId;
    }

    public void setEventId(Long eventId) {
        this.eventId = eventId;
    }

    public String getRank() {
        return rank;
    }

    public void setRank(String rank) {
        this.rank = rank;
    }

    public Integer getAmountOfSeats() {
        return amountOfSeats;
    }

    public void setAmountOfSeats(Integer amountOfSeats) {
        this.amountOfSeats = amountOfSeats;
    }

    @Override
    public String toString() {
        return "EventSeating{" +
                "id=" + id +
                ", event=" + eventId +
                ", rank='" + rank + '\'' +
                ", amountOfSeats=" + amountOfSeats +
                '}';
    }
}
