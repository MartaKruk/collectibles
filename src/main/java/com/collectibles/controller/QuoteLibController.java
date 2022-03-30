package com.collectibles.controller;

import com.collectibles.quotelib.client.QuoteLibClient;
import com.collectibles.domain.dto.QuoteLibDto;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping("/v1/quote")
@RequiredArgsConstructor
public class QuoteLibController {

    private final QuoteLibClient quoteLibClient;

    @GetMapping
    public void getRandomQuote() {
        List<QuoteLibDto> quoteLibDtoList = quoteLibClient.getRandomQuote();

        for (QuoteLibDto quoteLibDto : quoteLibDtoList) {
            System.out.println(quoteLibDto.getQuote_text());
            System.out.println(quoteLibDto.getAuthor());
        }
    }
}
