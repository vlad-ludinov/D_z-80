package book;


import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import java.util.ArrayList;

import static org.assertj.core.api.Assertions.*;

import static org.mockito.Mockito.mock;
import static org.mockito.Mockito.when;

class BookServiceTest {

    BookRepository bookRepository;
    BookService bookService;


    @BeforeEach
    void beforeTest() {
        BookRepository bookRepository = mock(InMemoryBookRepository.class);
        BookService bookService = new BookService(bookRepository);
    }

    @Test
    void testFindBookById() {
        when(bookRepository.findById("1")).thenReturn(new Book("1", "Book", "Author"));
        assertThat(bookService.findBookById("1")).isEqualTo(new Book("1", "Book", "Author"));
    }

    @Test
    void testFindAllBooks() {
        when(bookRepository.findAll()).thenReturn(new ArrayList<Book>());
        assertThat(bookService.findAllBooks()).isEqualTo(new ArrayList<Book>());
    }



}