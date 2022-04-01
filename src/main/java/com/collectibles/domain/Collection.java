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
@Table(name= "collections")
public class Collection {

    @Id
    @GeneratedValue
    @NotNull
    @Column(name="id", unique=true)
    private Long id;

    @Column(name="name")
    private String name;

    @ManyToMany(cascade = CascadeType.PERSIST)
    @JoinTable(
            name = "join_books_collections",
            joinColumns = {@JoinColumn(name = "collection_id", referencedColumnName = "id")},
            inverseJoinColumns = {@JoinColumn(name= "book_id", referencedColumnName = "id")}
    )
    private List<Book> books = new ArrayList<>();

    public Collection(Long id, String name) {
        this.id = id;
        this.name = name;
    }
}
