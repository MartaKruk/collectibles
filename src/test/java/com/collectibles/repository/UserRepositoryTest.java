package com.collectibles.repository;

import com.collectibles.domain.BooksCollection;
import com.collectibles.domain.MoviesCollection;
import com.collectibles.domain.User;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import java.util.List;
import java.util.Optional;

import static org.junit.jupiter.api.Assertions.*;
import static org.junit.jupiter.api.Assertions.assertNotNull;

@SpringBootTest
public class UserRepositoryTest {

    @Autowired
    private UserRepository userRepository;

    @Autowired
    private MoviesCollectionRepository moviesCollectionRepository;

    @Autowired
    private BooksCollectionRepository booksCollectionRepository;

    private static final String NAME = "Test name";

    private User createTestUser() {
        return new User(NAME, "Test email", "Test password");
    }

    @Test
    void testUserRepositorySave() {
        //Given
        User user = createTestUser();

        //When
        userRepository.save(user);

        //Then
        Long id = user.getId();
        Optional<User> testUser = userRepository.findById(id);
        assertTrue(testUser.isPresent());

        //Cleanup
        userRepository.deleteById(id);
    }

    @Test
    void testUserRepositoryFindByName() {
        //Given
        User user = createTestUser();

        //When
        userRepository.save(user);
        Long id = user.getId();
        List<User> testUsers = userRepository.findByName(NAME);

        //Then
        assertNotNull(testUsers);

        //Cleanup
        userRepository.deleteById(id);
    }

    @Test
    void testUserRepositorySave_shouldSaveMoviesCollections() {
        //Given
        User user = createTestUser();
        MoviesCollection moviesCollection = new MoviesCollection();
        user.getMoviesCollections().add(moviesCollection);

        //When
        userRepository.save(user);
        Long userId = user.getId();
        Long collectionId = moviesCollection.getId();
        Optional<MoviesCollection> testMoviesCollection = moviesCollectionRepository.findById(collectionId);

        //Then
        assertTrue(testMoviesCollection.isPresent());

        //Cleanup
        userRepository.deleteById(userId);
    }

    @Test
    void testUserRepositorySave_shouldSaveBooksCollections() {
        //Given
        User user = createTestUser();
        BooksCollection booksCollection = new BooksCollection();
        user.getBooksCollections().add(booksCollection);

        //When
        userRepository.save(user);
        Long userId = user.getId();
        Long collectionId = booksCollection.getId();
        Optional<BooksCollection> testBooksCollection = booksCollectionRepository.findById(collectionId);

        //Then
        assertTrue(testBooksCollection.isPresent());

        //Cleanup
        userRepository.deleteById(userId);
    }
}
