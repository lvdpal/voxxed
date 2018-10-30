package org.jduchess.microservices.domain;

import javax.persistence.*;

@Entity
public class EventSeating {
    @Id
    @GeneratedValue(strategy= GenerationType.AUTO)
    private Long id;

    @OneToOne
    private ProgrammingEvent programmingEvent;

    private String rank;
    private Integer amountOfSeats;

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public ProgrammingEvent getProgrammingEvent() {
        return programmingEvent;
    }

    public void setProgrammingEvent(ProgrammingEvent programmingEvent) {
        this.programmingEvent = programmingEvent;
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
}
