package com.maids.task;


import com.maids.task.controller.BookController;
import com.maids.task.dtos.BookDTO;
import com.maids.task.service.BookService;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;

import java.util.ArrayList;
import java.util.List;


import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.mockito.ArgumentMatchers.any;
import static org.mockito.Mockito.*;

@ExtendWith(MockitoExtension.class)
public class BookControllerTest {

    @Mock
    private BookService bookService;

    @InjectMocks
    private BookController bookController;

    @Test
    public void testGetAllBooks() {

        List<BookDTO> books = new ArrayList<>();
        books.add(new BookDTO(1L, "Book 1"));
        books.add(new BookDTO(2L, "Book 2"));

        when(bookService.getAllBooks()).thenReturn(books);

        ResponseEntity<List<BookDTO>> response = bookController.getAllBooks();

        assertEquals(HttpStatus.OK, response.getStatusCode());
        assertEquals(books, response.getBody());
        verify(bookService, times(1)).getAllBooks();
    }

    @Test
    public void testGetBookById() {

        Long bookId = 1L;
        BookDTO book = new BookDTO(bookId, "Book 1");

        when(bookService.getBookById(bookId)).thenReturn(book);

        ResponseEntity<BookDTO> response = bookController.getBookById(bookId);

        assertEquals(HttpStatus.OK, response.getStatusCode());
        assertEquals(book, response.getBody());
        verify(bookService, times(1)).getBookById(bookId);
    }

}
