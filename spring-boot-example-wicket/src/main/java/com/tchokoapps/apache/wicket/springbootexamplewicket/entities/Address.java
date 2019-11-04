package com.tchokoapps.apache.wicket.springbootexamplewicket.entities;

import lombok.Data;

import javax.persistence.Embeddable;
import java.io.Serializable;

@Data
@Embeddable
public class Address implements Serializable {

    private String street;
    private Integer number;
    private String district;
    private String city;
    private String state;
    private String cep;

    public Address() {
    }

    public Address(String street, Integer number, String district, String city, String state, String cep) {
        this.street = street;
        this.number = number;
        this.district = district;
        this.city = city;
        this.state = state;
        this.cep = cep;
    }
}
