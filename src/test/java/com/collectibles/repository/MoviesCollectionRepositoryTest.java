package com.collectibles.repository;

import com.collectibles.domain.*;
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

    @Autowired
    private MovieRepository movieRepository;

    @Autowired
    private UserRepository userRepository;

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

    @Test
    void testMoviesCollectionRepositorySave_shouldSaveMovies() {
        //Given
        Movie movie = new Movie();
        MoviesCollection moviesCollection = new MoviesCollection();
        moviesCollection.getMovies().add(movie);

        //When
        moviesCollectionRepository.save(moviesCollection);
        Long collectionId = moviesCollection.getId();
        Long movieId = movie.getId();
        Optional<Movie> testMovie = movieRepository.findById(movieId);

        //Then
        assertTrue(testMovie.isPresent());

        //Cleanup
        moviesCollectionRepository.deleteById(collectionId);
        movieRepository.deleteById(movieId);
    }

    @Test
    void testMoviesCollectionRepositoryDelete_shouldNotDeleteMovies() {
        //Given
        Movie movie = new Movie();
        MoviesCollection moviesCollection = new MoviesCollection();
        moviesCollection.getMovies().add(movie);

        //When
        moviesCollectionRepository.save(moviesCollection);
        Long collectionId = moviesCollection.getId();
        Long movieId = movie.getId();
        moviesCollectionRepository.deleteById(collectionId);
        Optional<Movie> testMovie = movieRepository.findById(movieId);

        //Then
        assertTrue(testMovie.isPresent());

        //Clenup
        movieRepository.deleteById(movieId);
    }

    @Test
    void testMoviesCollectionRepositoryDelete_shouldNotDeleteUser() {
        //Given
        User user = new User("Test name", "Test email", "Test password");
        MoviesCollection moviesCollection = new MoviesCollection();
        user.getMoviesCollections().add(moviesCollection);

        //When
        userRepository.save(user);
        Long collectionId = moviesCollection.getId();
        Long userId = user.getId();
        moviesCollectionRepository.deleteById(collectionId);
        Optional<User> testUser = userRepository.findById(userId);

        //Then
        assertTrue(testUser.isPresent());

        //Cleanup
        userRepository.deleteById(userId);
    }
}
