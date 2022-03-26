package com.collectibles.domain;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;

import javax.persistence.*;
import javax.validation.constraints.NotNull;
import java.time.LocalDate;
import java.time.LocalDateTime;

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

    @Column(name="lastLogin")
    private LocalDateTime lastLogin;
}
