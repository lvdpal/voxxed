package org.jduchess.microservices;

public class Address {
    private int id;
    private String street;
    private int houseNumber;
    private String houseNumberAddittion;
    private String postcode;
    private String town;
    private String country;

    public Address(){}

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getStreet() {
        return street;
    }

    public void setStreet(String street) {
        this.street = street;
    }

    public int getHouseNumber() {
        return houseNumber;
    }

    public void setHouseNumber(int houseNumber) {
        this.houseNumber = houseNumber;
    }

    public String getHouseNumberAddittion() {
        return houseNumberAddittion;
    }

    public void setHouseNumberAddittion(String houseNumberAddittion) {
        this.houseNumberAddittion = houseNumberAddittion;
    }

    public String getPostcode() {
        return postcode;
    }

    public void setPostcode(String postcode) {
        this.postcode = postcode;
    }

    public String getTown() {
        return town;
    }

    public void setTown(String town) {
        this.town = town;
    }

    public String getCountry() {
        return country;
    }

    public void setCountry(String country) {
        this.country = country;
    }
}
