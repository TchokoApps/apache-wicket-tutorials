package com.tchokoapps.apache.wicket.springbootwicketpro.common;

import lombok.Data;

import java.io.Serializable;

@Data
public class PhoneNumber implements Serializable {
    private String areaCode;
    private String prefix;
    private String number;

    public PhoneNumber(String areaCode, String prefix, String number) {
        this.areaCode = areaCode;
        this.prefix = prefix;
        this.number = number;
    }
}
