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
@Table(name="quotes")
public class Quote {

    @Id
    @GeneratedValue
    @NotNull
    @Column(name="id", unique=true)
    private Long id;

    @Column(name="author")
    private String author;

    @Column(name="content")
    private String content;

    @ManyToOne
    @JoinColumn(name="user_id")
    private User user;

    public Quote(Long id, String author, String content) {
        this.id = id;
        this.author = author;
        this.content = content;
    }
}
