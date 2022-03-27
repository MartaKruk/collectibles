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

    @Column(name="description")
    private String description;

    @Column(name="year")
    private String year;

    @Column(name="rating")
    private String rating;

    @Column(name="user_rating")
    private String userRating;

    @Column(name="user_note")
    private String userNote;

    @ManyToMany(cascade = CascadeType.PERSIST, mappedBy = "books")
    private List<BooksCollection> booksCollections = new ArrayList<>();

    public Book(String title, String author, String description, String year, String rating, String userRating, String userNote) {
        this.title = title;
        this.author = author;
        this.description = description;
        this.year = year;
        this.rating = rating;
        this.userRating = userRating;
        this.userNote = userNote;
    }
}
