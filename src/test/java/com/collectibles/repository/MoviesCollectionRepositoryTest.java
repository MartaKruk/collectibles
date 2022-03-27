package com.collectibles.repository;

import com.collectibles.domain.MoviesCollection;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import java.util.List;
import java.util.Optional;

import static org.junit.jupiter.api.Assertions.*;

@SpringBootTest
public class MoviesCollectionRepositoryTest {

    @Autowired
    private MoviesCollectionRepository moviesCollectionRepository;

    @Test
    void testMoviesCollectionRepositorySave() {
        //Given
        MoviesCollection moviesCollection = new MoviesCollection();

        //When
        moviesCollectionRepository.save(moviesCollection);

        //Then
        Long id = moviesCollection.getId();
        Optional<MoviesCollection> testMoviesCollection = moviesCollectionRepository.findById(id);
        assertTrue(testMoviesCollection.isPresent());

        //Cleanup
        moviesCollectionRepository.deleteById(id);
    }

    @Test
    void testMoviesCollectionRepositoryFindAll() {
        //Given
        MoviesCollection moviesCollection = new MoviesCollection();

        //When
        moviesCollectionRepository.save(moviesCollection);
        Long id = moviesCollection.getId();
        List<MoviesCollection> testMoviesCollections = moviesCollectionRepository.findAll();

        //Then
        assertNotNull(testMoviesCollections);
        assertNotEquals(0, testMoviesCollections.size());

        //Cleanup
        moviesCollectionRepository.deleteById(id);

    }
}
