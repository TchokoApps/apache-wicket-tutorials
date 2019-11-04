package com.tchokoapps.apache.wicket.springbootexamplewicket.entities;

import lombok.Data;

import java.io.Serializable;

public enum AppointmentStatus implements Serializable {

    CANCEL("cancel"), PENDING("pending"), PERFORMED("performed");

    private final String text;

    AppointmentStatus(final String text) {
        this.text = text;
    }

    public String getText() {
        return text;
    }
}
