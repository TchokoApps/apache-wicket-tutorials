package com.tchokoapps.apache.wicket.springbootwicketpro.entities;

import lombok.Data;

import javax.persistence.*;
import java.util.HashSet;
import java.util.Set;

@Data
@Entity
public class Category {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private String name;
    @OneToMany(cascade = CascadeType.ALL, mappedBy = "category")
    private Set<Book> books = new HashSet<>();
}
