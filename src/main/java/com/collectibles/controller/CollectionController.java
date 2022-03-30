package com.collectibles.controller;

import com.collectibles.domain.Collection;
import com.collectibles.domain.dto.CollectionDto;
import com.collectibles.exceptions.CollectionNotFoundException;
import com.collectibles.mapper.CollectionMapper;
import com.collectibles.service.CollectionService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/v1/collections")
@RequiredArgsConstructor
public class CollectionController {

    private final CollectionService collectionService;
    private final CollectionMapper collectionMapper;

    @GetMapping
    public ResponseEntity<List<CollectionDto>> getCollections() {
        List<Collection> collections = collectionService.getAllCollections();
        return ResponseEntity.ok(collectionMapper.mapToCollectionDtoList(collections));
    }

    @GetMapping(value = "{id}")
    public ResponseEntity<CollectionDto> getCollection(@PathVariable Long id) throws CollectionNotFoundException {
        return new ResponseEntity<>(collectionMapper.mapToCollectionDto(collectionService.getCollection(id)), HttpStatus.OK);
    }

    @DeleteMapping(value = "{id}")
    public ResponseEntity<Void> deleteCollection(@PathVariable Long id) throws CollectionNotFoundException {
        collectionService.deleteCollection(id);
        return ResponseEntity.ok().build();
    }

    @PutMapping(consumes = MediaType.APPLICATION_JSON_VALUE)
    public ResponseEntity<CollectionDto> updateCollection(CollectionDto collectionDto) {
        Collection collection = collectionMapper.mapToCollection(collectionDto);
        Collection savedCollection = collectionService.saveCollection(collection);
        return ResponseEntity.ok(collectionMapper.mapToCollectionDto(savedCollection));
    }

    @PostMapping(consumes = MediaType.APPLICATION_JSON_VALUE)
    public ResponseEntity<Void> createCollection(CollectionDto collectionDto) {
        Collection collection = collectionMapper.mapToCollection(collectionDto);
        collectionService.saveCollection(collection);
        return ResponseEntity.ok().build();
        //TODO: fix endpoint after Postman test
    }

    //TODO: add book to collection endpoint

    //TODO: remove book from collection endpoint

    //TODO: get books in collection endpoint
}
