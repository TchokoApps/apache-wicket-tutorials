package com.tchokoapps.apache.wicket.springbootexamplewicket.entities;

import com.mysema.query.annotations.Config;
import lombok.Data;

import javax.persistence.*;
import javax.validation.constraints.NotNull;
import java.io.Serializable;
import java.time.LocalDate;
import java.time.LocalDateTime;

@Data
@Entity
@Config(listAccessors = true, entityAccessors = true)
public class Doctor implements Serializable {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private String name;

    @NotNull
    @Enumerated(EnumType.STRING)
    private Sex sex;

    @NotNull
    @OneToOne
    @JoinColumn(name = "specialty")
    private Specialty specialty;

    @NotNull
    private LocalDate admissionDate;

    @NotNull
    private LocalDate dateOfBirth;

    @Column(name = "registration_date")
    private LocalDateTime registrationDate;

    private String crm;

    @NotNull
    @Embedded
    private Address address;

    private boolean active = true;

    public Doctor() {
    }

    public Doctor(@NotNull Address address) {
        this.address = address;
    }

    public Doctor(String name, @NotNull Sex sex, @NotNull Specialty specialty, @NotNull LocalDate admissionDate, @NotNull LocalDate dateOfBirth, LocalDateTime registrationDate, String crm, @NotNull Address address, boolean active) {
        this.name = name;
        this.sex = sex;
        this.specialty = specialty;
        this.admissionDate = admissionDate;
        this.dateOfBirth = dateOfBirth;
        this.registrationDate = registrationDate;
        this.crm = crm;
        this.address = address;
        this.active = active;
    }
}
