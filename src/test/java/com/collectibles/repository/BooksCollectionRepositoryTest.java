package com.collectibles.repository;

import com.collectibles.domain.Book;
import com.collectibles.domain.BooksCollection;
import com.collectibles.domain.User;
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

    @Autowired
    private BookRepository bookRepository;

    @Autowired
    private UserRepository userRepository;

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

    @Test
    void testBooksCollectionRepositorySave_shouldSaveBooks() {
        //Given
        Book book = new Book();
        BooksCollection booksCollection = new BooksCollection();
        booksCollection.getBooks().add(book);

        //When
        booksCollectionRepository.save(booksCollection);
        Long collectionId = booksCollection.getId();
        Long bookId = book.getId();
        Optional<Book> testBook = bookRepository.findById(bookId);

        //Then
        assertTrue(testBook.isPresent());

        //Cleanup
        booksCollectionRepository.deleteById(collectionId);
        bookRepository.deleteById(bookId);
    }

    @Test
    void testBooksCollectionRepositoryDelete_shouldNotDeleteBooks() {
        //Given
        Book book = new Book();
        BooksCollection booksCollection = new BooksCollection();
        booksCollection.getBooks().add(book);

        //When
        booksCollectionRepository.save(booksCollection);
        Long collectionId = booksCollection.getId();
        Long bookId = book.getId();
        booksCollectionRepository.deleteById(collectionId);
        Optional<Book> testBook = bookRepository.findById(bookId);

        //Then
        assertTrue(testBook.isPresent());

        //Cleanup
        bookRepository.deleteById(bookId);
    }

    @Test
    void testBooksCollectionRepositoryDelete_shouldNotDeleteUser() {
        //Given
        User user = new User("Test name", "Test email", "Test password");
        BooksCollection booksCollection = new BooksCollection();
        user.getBooksCollections().add(booksCollection);

        //When
        userRepository.save(user);
        Long userId = user.getId();
        Long collectionId = booksCollection.getId();
        booksCollectionRepository.deleteById(collectionId);
        Optional<User> testUser = userRepository.findById(userId);

        //Then
        assertTrue(testUser.isPresent());

        //Cleanup
        userRepository.deleteById(userId);
    }
}
