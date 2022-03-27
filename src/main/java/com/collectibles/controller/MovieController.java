package com.collectibles.controller;

import com.collectibles.domain.MovieDto;
import org.springframework.web.bind.annotation.*;

import java.util.ArrayList;
import java.util.List;

@RestController
@RequestMapping("/v1/movie")
public class MovieController {

    @GetMapping(value = "getMovies")
    public List<MovieDto> getMovies() {
        return new ArrayList<>();
    }

    @GetMapping(value = "getMovie")
    public MovieDto getMovie(Long id) {
        return new MovieDto();
    }

    @DeleteMapping(value = "deleteMovie")
    public void deleteMovie(Long id) {
    }

    @PutMapping(value = "updateMovie")
    public MovieDto updateMovie(MovieDto movieDto) {
        return new MovieDto();
    }

    @PostMapping(value = "createMovie")
    public void createMovie(MovieDto movieDto) {
    }
}
