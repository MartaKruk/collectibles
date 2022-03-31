package com.collectibles.controller;

import com.collectibles.domain.dto.ResultBookDto;
import com.collectibles.domain.dto.ResultDto;
import com.collectibles.openlibrary.client.OpenLibraryClient;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/v1/search")
@RequiredArgsConstructor
public class OpenLibraryController {

    private final OpenLibraryClient openLibraryClient;

    @GetMapping(value = "/author/{keyword}")
    public void getBookByAuthor(@PathVariable String keyword) {
        ResultDto resultDto = openLibraryClient.getBookByAuthor(keyword);

        for(ResultBookDto resultBookDto : resultDto.getBooks()) {
            System.out.println(resultBookDto.getTitle());
        }
    }

    @GetMapping(value = "/title/{keyword}")
    public void getBookByTitle(@PathVariable String keyword) {
        ResultDto resultDto = openLibraryClient.getBookByTitle(keyword);

        for(ResultBookDto resultBookDto : resultDto.getBooks()) {
            System.out.println(resultBookDto.getTitle());
        }
    }
}
