package com.collectibles.controller;

import com.collectibles.domain.MoviesCollectionDto;
import org.springframework.web.bind.annotation.*;

import java.util.ArrayList;
import java.util.List;

@RestController
@RequestMapping("/v1/moviesCollection")
public class MoviesCollectionController {

    @GetMapping(value = "getMoviesCollections")
    public List<MoviesCollectionDto> getMoviesCollections() {
        return new ArrayList<>();
    }

    @GetMapping(value = "getMoviesCollection")
    public MoviesCollectionDto getMoviesCollection(Long id) {
        return new MoviesCollectionDto();
    }

    @DeleteMapping(value = "deleteMoviesCollection")
    public void deleteMoviesCollection(Long id) {
    }

    @PutMapping(value = "updateMoviesCollection")
    public MoviesCollectionDto updateMoviesCollection(MoviesCollectionDto moviesCollectionDto) {
        return new MoviesCollectionDto();
    }

    @PostMapping(value = "createMoviesCollection")
    public void createMoviesCollection(MoviesCollectionDto moviesCollectionDto) {
    }
}
