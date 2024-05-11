package com.maids.task;


import com.maids.task.controller.BookController;
import com.maids.task.controller.PatronController;
import com.maids.task.dtos.BookDTO;
import com.maids.task.dtos.PatronDTO;
import com.maids.task.service.BookService;
import com.maids.task.service.PatronService;
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
import static org.mockito.Mockito.*;

@ExtendWith(MockitoExtension.class)
public class PatronControllerTest {

    @Mock
    private PatronService bookService;

    @InjectMocks
    private PatronController bookController;

    @Test
    public void testGetAllPatrons() {

        List<PatronDTO> patrons = new ArrayList<>();
        patrons.add(new PatronDTO(1L, "Book 1"));
        patrons.add(new PatronDTO(2L, "Book 2"));

        when(bookService.getAllPatrons()).thenReturn(patrons);

        ResponseEntity<List<PatronDTO>> response = bookController.getAllPatrons();

        assertEquals(HttpStatus.OK, response.getStatusCode());
        assertEquals(patrons, response.getBody());
        verify(bookService, times(1)).getAllPatrons();
    }

    @Test
    public void testGetBookById() {

        Long patronId = 1L;
        PatronDTO patron = new PatronDTO(patronId, "Book 1");

        when(bookService.getPatronById(patronId)).thenReturn(patron);

        ResponseEntity<PatronDTO> response = bookController.getPatronById(patronId);

        assertEquals(HttpStatus.OK, response.getStatusCode());
        assertEquals(patron, response.getBody());
        verify(bookService, times(1)).getPatronById(patronId);
    }

}
