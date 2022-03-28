package com.collectibles.controller;

import com.collectibles.domain.dto.QuoteDto;
import org.springframework.web.bind.annotation.*;

import java.util.ArrayList;
import java.util.List;

@RestController
@RequestMapping("/v1/quote")
public class QuoteController {

    @GetMapping(value = "getQuotes")
    public List<QuoteDto> getQuotes() {
        return new ArrayList<>();
    }

    @GetMapping(value = "getQuote")
    public QuoteDto getQuote(Long id) {
        return new QuoteDto();
    }

    @DeleteMapping(value = "deleteQuote")
    public void deleteQuote(Long id) {
    }

    @PutMapping(value = "updateQuote")
    public QuoteDto updateQuote(QuoteDto quoteDto) {
        return new QuoteDto();
    }

    @PostMapping(value = "createQuote")
    public void createQuote(QuoteDto quoteDto) {
    }
}
