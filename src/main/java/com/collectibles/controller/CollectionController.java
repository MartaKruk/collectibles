package com.collectibles.controller;

import com.collectibles.domain.dto.CollectionDto;
import org.springframework.web.bind.annotation.*;

import java.util.ArrayList;
import java.util.List;

@RestController
@RequestMapping("/v1/collection")
public class CollectionController {

    @GetMapping(value = "getCollections")
    public List<CollectionDto> getCollections() {
        return new ArrayList<>();
    }

    @GetMapping(value = "getCollection")
    public CollectionDto getCollection(Long id) {
        return new CollectionDto();
    }

    @DeleteMapping(value = "deleteCollection")
    public void deleteCollection(Long id) {
    }

    @PutMapping(value = "updateCollection")
    public CollectionDto updateCollection(CollectionDto collectionDto) {
        return new CollectionDto();
    }

    @PostMapping(value = "createCollection")
    public void createCollection(CollectionDto collectionDto) {
    }

    //TODO: add book to collection endpoint

    //TODO: remove book from collection endpoint

    //TODO: get books in collection endpoint
}
