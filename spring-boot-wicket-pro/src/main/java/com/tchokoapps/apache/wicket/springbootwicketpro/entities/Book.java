package com.tchokoapps.apache.wicket.springbootwicketpro.entities;

import lombok.Data;

import javax.persistence.*;
import java.io.Serializable;

@Data
@Entity()
public class Book implements Serializable {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private String title;
    private String author;
    private float price;
    private String publisher;
    @ManyToOne
    private Category category;
}
