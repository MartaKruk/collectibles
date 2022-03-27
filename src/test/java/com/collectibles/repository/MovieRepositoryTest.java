package com.collectibles.repository;

import com.collectibles.domain.Movie;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import java.util.List;
import java.util.Optional;

import static org.junit.jupiter.api.Assertions.*;
import static org.junit.jupiter.api.Assertions.assertNotNull;

@SpringBootTest
public class MovieRepositoryTest {

    @Autowired
    private MovieRepository movieRepository;

    private Movie createTestMovie() {
        return new Movie("Test title", "Test director", "Test description", "2020", "Test rating", "Test user rating", "Test user note");
    }

    @Test
    void testMovieRepositoryFindAll() {
        //Given
        Movie movie = createTestMovie();

        //When
        movieRepository.save(movie);
        Long id = movie.getId();
        List<Movie> testMovies = movieRepository.findAll();

        //Then
        assertNotNull(testMovies);
        assertNotEquals(0, testMovies.size());

        //Cleanup
        movieRepository.deleteById(id);
    }

    @Test
    void testMovieRepositorySave() {
        //Given
        Movie movie = createTestMovie();

        //When
        movieRepository.save(movie);

        //Then
        Long id = movie.getId();
        Optional<Movie> testMovie = movieRepository.findById(id);
        assertTrue(testMovie.isPresent());

        //Cleanup
        movieRepository.deleteById(id);
    }

    @Test
    void testMovieRepositoryFindById() {
        //Given
        Movie movie = createTestMovie();

        //When
        movieRepository.save(movie);
        Long id = movie.getId();
        Optional<Movie> testMovie = movieRepository.findById(id);

        //Then
        assertNotNull(testMovie);

        //Cleanup
        movieRepository.deleteById(id);
    }
}
