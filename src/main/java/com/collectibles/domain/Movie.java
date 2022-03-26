package com.collectibles.domain;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;

import javax.persistence.*;
import javax.validation.constraints.NotNull;

@Getter
@AllArgsConstructor
@NoArgsConstructor
@Entity
@Table(name="movies")
public class Movie implements Collectible {

    @Id
    @GeneratedValue
    @NotNull
    @Column(name="id", unique=true)
    private Long id;

    @Column(name="title")
    private String title;

    @Column(name="director")
    private String director;

    @Column(name="description")
    private String description;

    @Column(name="year")
    private String year;

    @Column(name="genre")
    private String genre;

    @Column(name="rating")
    private String rating;

    @Column(name="userRating")
    private String userRating;

    @Column(name="userNote")
    private String userNote;
}
