package com.collectibles.controller;

import com.collectibles.domain.dto.ResultBookDto;
import com.collectibles.domain.dto.ResultDto;
import com.collectibles.service.OpenLibraryService;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/v1/search")
@RequiredArgsConstructor
public class OpenLibraryController {

    private final OpenLibraryService openLibraryService;

    @GetMapping(value = "/author/{keyword}")
    public void getBookByAuthor(@PathVariable String keyword) {
        ResultDto resultDto = openLibraryService.fetchBookByAuthor(keyword);

        for(ResultBookDto resultBookDto : resultDto.getBooks()) {
            System.out.println(resultBookDto.getTitle());
        }
    }

    @GetMapping(value = "/title/{keyword}")
    public void getBookByTitle(@PathVariable String keyword) {
        ResultDto resultDto = openLibraryService.fetchBookByTitle(keyword);

        for(ResultBookDto resultBookDto : resultDto.getBooks()) {
            System.out.println(resultBookDto.getTitle());
        }
    }
}
