package com.collectibles.repository;

import com.collectibles.domain.Book;
import com.collectibles.domain.BooksCollection;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import java.util.List;
import java.util.Optional;

import static org.junit.jupiter.api.Assertions.*;

@SpringBootTest
public class BooksCollectionRepositoryTest {

    @Autowired
    private BooksCollectionRepository booksCollectionRepository;

    @Test
    void testBooksCollectionRepositorySave() {
        //Given
        BooksCollection booksCollection = new BooksCollection();

        //When
        booksCollectionRepository.save(booksCollection);

        //Then
        Long id = booksCollection.getId();
        Optional<BooksCollection> testBooksCollection = booksCollectionRepository.findById(id);
        assertTrue(testBooksCollection.isPresent());

        //Cleanup
        booksCollectionRepository.deleteById(id);
    }

    @Test
    void testBooksCollectionRepositoryFindAll() {
        //Given
        BooksCollection booksCollection = new BooksCollection();

        //When
        booksCollectionRepository.save(booksCollection);
        Long id = booksCollection.getId();
        List<BooksCollection> testBooksCollections = booksCollectionRepository.findAll();

        //Then
        assertNotNull(testBooksCollections);
        assertNotEquals(0, testBooksCollections.size());

        //Cleanup
        booksCollectionRepository.deleteById(id);
    }
}
