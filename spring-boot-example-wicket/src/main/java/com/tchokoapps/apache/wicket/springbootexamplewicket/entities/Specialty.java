package com.tchokoapps.apache.wicket.springbootexamplewicket.entities;

import lombok.Data;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

@Data
@Entity
public class Specialty {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private String name;

    public Specialty() {
    }

    public Specialty(String name) {
        this.name = name;
    }
}
