package com.collectibles.domain;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;

import javax.persistence.*;
import javax.validation.constraints.NotNull;
import java.util.ArrayList;
import java.util.List;

@Getter
@AllArgsConstructor
@NoArgsConstructor
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

    @Column(name="user_rating")
    private String userRating;

    @ManyToMany(cascade = CascadeType.PERSIST, mappedBy = "books")
    private List<Collection> collections = new ArrayList<>();

    public Book(String title, String author, String description, String year, String rating, String userRating, String userNote) {
        this.title = title;
        this.author = author;
        this.userRating = userRating;
    }
}
