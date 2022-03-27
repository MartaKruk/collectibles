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
@Table(name="movies_collections")
public class MoviesCollection {

    @Id
    @GeneratedValue
    @NotNull
    @Column(name="id", unique=true)
    private Long id;

    @Column(name="name")
    private String name;

    @Column(name="description")
    private String description;

    @ManyToOne
    @JoinColumn(name="user_id")
    private User user;

    @ManyToMany(cascade = CascadeType.PERSIST)
    @JoinTable(
            name = "join_movies_collections",
            joinColumns = {@JoinColumn(name = "collection_id", referencedColumnName = "id")},
            inverseJoinColumns = {@JoinColumn(name= "movie_id", referencedColumnName = "id")}
    )
    private List<Movie> movies = new ArrayList<>();
}
