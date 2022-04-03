package com.collectibles.domain;

import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;

import javax.persistence.*;
import javax.validation.constraints.NotNull;

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

    @Column(name="year")
    private String year;

    @Column(name= "note")
    private String note;

    @ManyToOne
    @JoinColumn(name= "collection_id")
    private Collection collection;

    public Book(Long id, String title, String author, String year, String note) {
        this.id = id;
        this.title = title;
        this.author = author;
        this.year = year;
        this.note = note;
    }

    public Book(String title, String author, String note) {
        this.title = title;
        this.author = author;
        this.note = note;
    }

    public void setCollection(Collection collection) {
        this.collection = collection;
    }
}
