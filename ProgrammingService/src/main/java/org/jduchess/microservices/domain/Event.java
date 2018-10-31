package org.jduchess.microservices.domain;

import javax.persistence.*;
import java.util.List;

@Entity
public class Event {
    @Id
    @GeneratedValue(strategy= GenerationType.AUTO)
    private Long id;

    private String location;

    private String name;

    @OneToMany
    @JoinColumn(name = "event_id", referencedColumnName = "id")
    private List<EventSeating> eventSeatings;

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getLocation() {
        return location;
    }

    public void setLocation(String location) {
        this.location = location;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public List<EventSeating> getEventSeatings() {
        return eventSeatings;
    }

    public void setEventSeatings(List<EventSeating> eventSeatings) {
        this.eventSeatings = eventSeatings;
    }

    @Override
    public String toString() {
        return "Event{" +
                "id=" + id +
                ", location='" + location + '\'' +
                ", name='" + name + '\'' +
                ", eventSeatings=" + eventSeatings +
                '}';
    }
}
