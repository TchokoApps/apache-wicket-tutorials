package com.tchokoapps.apache.wicket.springbootwicketpro.common;

import lombok.Data;

import java.io.Serializable;

@Data
public class UserProfile implements Serializable {
    private String name;
    private String address;
    private String city;
    private String country;
    private String state;
    private String zipCode;
    private int pin;
    private PhoneNumber phoneNumber;
}
