package com.maids.task.service;

import com.maids.task.dtos.BookDTO;
import org.springframework.stereotype.Service;

import java.util.List;

public interface BookService {

    List<BookDTO> getAllBooks();
    BookDTO getBookById(Long id);
    BookDTO saveBook(BookDTO bookDTO);
    BookDTO updateBook(Long id, BookDTO bookDTO);
    Boolean deleteBook(Long id);
}
