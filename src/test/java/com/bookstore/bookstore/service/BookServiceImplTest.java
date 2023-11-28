package com.bookstore.bookstore.service;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertNotNull;
import static org.junit.jupiter.api.Assertions.assertThrows;
import static org.mockito.Mockito.times;
import static org.mockito.Mockito.verify;
import static org.mockito.Mockito.when;

import java.util.Arrays;
import java.util.List;
import java.util.Optional;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.MockitoAnnotations;

import com.bookstore.bookstore.Dao.BookRepository;
import com.bookstore.bookstore.entity.Book;

class BookServiceImplTest {

    @Mock
    private BookRepository bookRepository;

    @InjectMocks
    private BookServiceImpl bookService;

    @BeforeEach
    void setUp() {
        MockitoAnnotations.openMocks(this);
    }

    @Test
    void testFindAll() {
        // Arrange
        List<Book> books = Arrays.asList(new Book(1L, "Book1", "Author1", null, null, null), new Book(2L, "Book2", "Author2", null, null, null));
        when(bookRepository.findAll()).thenReturn(books);

        // Act
        List<Book> result = bookService.findAll();

        // Assert
        assertEquals(2, result.size());
        verify(bookRepository, times(1)).findAll();
    }

    @Test
    void testFindById() {
        // Arrange
        long bookId = 1L;
        Book book = new Book(bookId, "Book1", "Author1", null, null, null);
        when(bookRepository.findById(bookId)).thenReturn(Optional.of(book));

        // Act
        Book result = bookService.findById(bookId);

        // Assert
        assertNotNull(result);
        assertEquals(bookId, result.getId());
        verify(bookRepository, times(1)).findById(bookId);
    }

    @Test
    void testFindByIdNotFound() {
        // Arrange
        long bookId = 1L;
        when(bookRepository.findById(bookId)).thenReturn(Optional.empty());

        // Act & Assert
        assertThrows(RuntimeException.class, () -> bookService.findById(bookId));
        verify(bookRepository, times(1)).findById(bookId);
    }

    @Test
    void testSave() {
        // Arrange
        Book bookToSave = new Book(0L, "NewBook", "NewAuthor", null, null, null);

        // Act
        bookService.save(bookToSave);

        // Assert
        verify(bookRepository, times(1)).save(bookToSave);
    }

    @Test
    void testDeleteById() {
        // Arrange
        long bookId = 1L;

        // Act
        bookService.deleteById(bookId);

        // Assert
        verify(bookRepository, times(1)).deleteById(bookId);
    }
}