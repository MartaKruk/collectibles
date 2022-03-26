package com.collectibles.domain;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;

@Getter
@AllArgsConstructor
@NoArgsConstructor
public class BookDto {
    private Long id;
    private String title;
    private String author;
    private String description;
    private String year;
    private String genre;
    private String rating;
    private String userRating;
    private String userNote;
}
