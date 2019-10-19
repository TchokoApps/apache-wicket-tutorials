package com.tchokoapps.apache.wicket.springbootexamplewicket.entities;

import com.mysema.query.annotations.Config;
import lombok.Data;

import javax.persistence.*;
import javax.validation.constraints.NotNull;
import java.io.Serializable;
import java.math.BigDecimal;
import java.time.LocalDateTime;

@Data
@Entity
@Config(listAccessors = true, entityAccessors = true)
public class Appointment {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @NotNull
    @ManyToOne
    @JoinColumn(name = "doctor")
    private Doctor doctor;

    @NotNull
    @ManyToOne
    @JoinColumn(name = "patient")
    private Patient patient;

    @NotNull
    private LocalDateTime appointmentDateTime;

    private LocalDateTime registrationDate;

    @NotNull
    @Enumerated(EnumType.STRING)
    private AppointmentStatus status;

    @NotNull
    private BigDecimal value;

    private String description;

    public Appointment(Long id, @NotNull Doctor doctor, @NotNull Patient patient, @NotNull LocalDateTime appointmentDateTime, LocalDateTime registrationDate, @NotNull AppointmentStatus status, @NotNull BigDecimal value, String description) {
        this.id = id;
        this.doctor = doctor;
        this.patient = patient;
        this.appointmentDateTime = appointmentDateTime;
        this.registrationDate = registrationDate;
        this.status = status;
        this.value = value;
        this.description = description;
    }

    public Appointment(@NotNull Doctor doctor, @NotNull Patient patient, @NotNull LocalDateTime appointmentDateTime, LocalDateTime registrationDate, @NotNull AppointmentStatus status, @NotNull BigDecimal value, String description) {
        this.doctor = doctor;
        this.patient = patient;
        this.appointmentDateTime = appointmentDateTime;
        this.registrationDate = registrationDate;
        this.status = status;
        this.value = value;
        this.description = description;
    }

    public Appointment(@NotNull Doctor doctor, @NotNull Patient patient, @NotNull LocalDateTime appointmentDateTime) {
        this.doctor = doctor;
        this.patient = patient;
        this.appointmentDateTime = appointmentDateTime;
    }
}
