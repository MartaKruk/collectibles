package com.collectibles.controller;

import com.collectibles.domain.dto.BookDto;
import org.springframework.web.bind.annotation.*;

import java.util.ArrayList;
import java.util.List;

@RestController
@RequestMapping("/v1/book")
public class BookController {

    @GetMapping(value = "getBooks")
    public List<BookDto> getBooks() {
        return new ArrayList<>();
    }

    @GetMapping(value = "getBook")
    public BookDto getBook(Long id) {
        return new BookDto();
    }

    @DeleteMapping(value = "deleteBook")
    public void deleteBook(Long id) {
    }

    @PutMapping(value = "updateBook")
    public BookDto updateBook(BookDto bookDto) {
        return new BookDto();
    }

    @PostMapping(value = "createBook")
    public void createBook(BookDto bookDto) {
    }
}
