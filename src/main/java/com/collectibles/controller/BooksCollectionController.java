package com.collectibles.controller;

import com.collectibles.domain.BooksCollectionDto;
import org.springframework.web.bind.annotation.*;

import java.util.ArrayList;
import java.util.List;

@RestController
@RequestMapping("/v1/booksCollection")
public class BooksCollectionController {

    @GetMapping(value = "getBooksCollections")
    public List<BooksCollectionDto> getBooksCollections() {
        return new ArrayList<>();
    }

    @GetMapping(value = "getBooksCollection")
    public BooksCollectionDto getBooksCollection(Long id) {
        return new BooksCollectionDto();
    }

    @DeleteMapping(value = "deleteBooksCollection")
    public void deleteBooksCollection(Long id) {
    }

    @PutMapping(value = "updateBooksCollection")
    public BooksCollectionDto updateBooksCollection(BooksCollectionDto booksCollectionDto) {
        return new BooksCollectionDto();
    }

    @PostMapping(value = "createBooksCollection")
    public void createBooksCollection(BooksCollectionDto booksCollectionDto) {
    }
}
