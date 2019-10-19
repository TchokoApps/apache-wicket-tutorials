package com.tchokoapps.apache.wicket.springbootexamplewicket.entities;

import lombok.Data;

public enum AppointmentStatus {

    CANCEL("cancel"), PENDING("pending"), PERFORMED("performed");

    private final String text;

    AppointmentStatus(final String text) {
        this.text = text;
    }

    public String getText() {
        return text;
    }
}
