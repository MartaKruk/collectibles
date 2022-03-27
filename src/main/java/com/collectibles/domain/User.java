package com.collectibles.domain;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;

import javax.persistence.*;
import javax.validation.constraints.NotNull;
import java.time.LocalDate;
import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.List;

@Getter
@AllArgsConstructor
@NoArgsConstructor
@Entity
@Table(name="users")
public class User {

    @Id
    @GeneratedValue
    @NotNull
    @Column(name="id", unique=true)
    private Long id;

    @Column(name="name")
    @NotNull
    private String name;

    @Column(name="email")
    private String email;

    @Column(name="password")
    @NotNull
    private String password;

    @Column(name="registration")
    @NotNull
    private LocalDate registration;

    @Column(name="last_login")
    private LocalDateTime lastLogin;

    @OneToMany(
            targetEntity = MoviesCollection.class,
            mappedBy = "user",
            cascade = CascadeType.PERSIST,
            fetch = FetchType.LAZY
    )
    private List<MoviesCollection> moviesCollections = new ArrayList<>();

    @OneToMany(
            targetEntity = BooksCollection.class,
            mappedBy = "user",
            cascade = CascadeType.PERSIST,
            fetch = FetchType.LAZY
    )
    private List<BooksCollection> booksCollections = new ArrayList<>();

    public User(String name, String email, String password) {
        this.name = name;
        this.email = email;
        this.password = password;
        this.registration = LocalDate.now();
    }
}
