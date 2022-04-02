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

    @OneToMany(
            targetEntity = Book.class,
            mappedBy = "collection",
            cascade = CascadeType.PERSIST,
            fetch = FetchType.LAZY
    )
    private List<Book> books = new ArrayList<>();

    public Collection(Long id, String name) {
        this.id = id;
        this.name = name;
    }
}
