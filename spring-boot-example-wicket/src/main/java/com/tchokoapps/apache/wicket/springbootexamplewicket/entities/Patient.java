package com.tchokoapps.apache.wicket.springbootexamplewicket.entities;


import com.mysema.query.annotations.Config;
import com.sun.istack.NotNull;
import lombok.Data;

import javax.persistence.*;
import java.time.LocalDate;
import java.time.LocalDateTime;

@Data
@Entity
@Config(listAccessors = true, entityAccessors = true)
public class Patient {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private String name;

    @NotNull
    @Enumerated(EnumType.STRING)
    private Sex sex;

    @Column(name = "registration_date")
    private LocalDateTime registrationDate;

    @NotNull
    @Column(name = "date_of_birth")
    private LocalDate dateOfBirth;

    private String cpf;

    @NotNull
    @Embedded
    private Address address;

    private boolean active = true;

    public Patient() {
    }

    public Patient(Address address) {
        this.address = address;
    }

    public Patient(String name, Sex sex, LocalDateTime registrationDate, LocalDate dateOfBirth, String cpf, Address address, boolean active) {
        this.name = name;
        this.sex = sex;
        this.registrationDate = registrationDate;
        this.dateOfBirth = dateOfBirth;
        this.cpf = cpf;
        this.address = address;
        this.active = active;
    }
}


