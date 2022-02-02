package com.example.library.model;

import lombok.Getter;

import javax.persistence.*;
import java.util.Set;

@Getter
@Entity
@Table(name = "author")
public class Author {

    @Id
    @GeneratedValue(strategy = GenerationType.SEQUENCE)
    private Long id;

    private String name;

    @OneToMany(mappedBy = "book")
    private Set<Book> book;

}
