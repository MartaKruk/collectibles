package com.collectibles.domain;

import lombok.Getter;
import lombok.NoArgsConstructor;

import javax.persistence.*;
import javax.validation.constraints.NotNull;
import java.util.ArrayList;
import java.util.List;

@NoArgsConstructor
@Getter
@Entity
@Table(name="books")
public class Book {

    @Id
    @GeneratedValue
    @NotNull
    @Column(name="id", unique=true)
    private Long id;

    @Column(name="title")
    private String title;

    @Column(name="author")
    private String author;

    @Column(name= "note")
    private String note;

    @ManyToMany(cascade = CascadeType.PERSIST, mappedBy = "books")
    private List<Collection> collections = new ArrayList<>();

    public Book(Long id, String title, String author, String note) {
        this.id = id;
        this.title = title;
        this.author = author;
        this.note = note;
    }

    public Book(String title, String author, String note) {
        this.title = title;
        this.author = author;
        this.note = note;
    }
}
