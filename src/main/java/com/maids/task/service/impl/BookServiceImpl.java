package com.maids.task.service.impl;

import com.maids.task.dtos.BookDTO;
import com.maids.task.exception.BookDuplicateIDException;
import com.maids.task.exception.BookNotFoundException;
import com.maids.task.mapper.BookMapper;
import com.maids.task.model.Book;
import com.maids.task.repo.BookRepository;
import com.maids.task.service.BookService;
import lombok.RequiredArgsConstructor;
import org.springframework.cache.annotation.CacheEvict;
import org.springframework.cache.annotation.Cacheable;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;

@Service
@RequiredArgsConstructor
public class BookServiceImpl implements BookService {

     BookRepository bookRepository;
     BookMapper bookMapper;

    @Cacheable("books")
    public List<BookDTO> getAllBooks() {
        List<Book> books = bookRepository.findAll();
        return books.stream()
                .map(bookMapper::toDTO)
                .collect(Collectors.toList());
    }

    @Cacheable(value = "books", key = "#id")
    public BookDTO getBookById(Long id) {
        Book book = bookRepository.findById(id)
                .orElseThrow(() -> new BookNotFoundException("Book not found with ID: " + id));
        return bookMapper.toDTO(book);
    }

    @CacheEvict(value = "books", allEntries = true)
    public BookDTO saveBook(BookDTO bookDTO) {
        if(bookRepository.existsById(bookDTO.getId())) {
            Book book = bookMapper.toEntity(bookDTO);
            Book savedBook = bookRepository.save(book);
            return bookMapper.toDTO(savedBook);
        }else{
            throw new BookDuplicateIDException("OOPS Book With ID: "+ bookDTO.getId()+" Is Duplicated");
        }
    }

    @CacheEvict(value = "books", key = "#id")
    public BookDTO updateBook(Long id, BookDTO bookDTO) {
        Book existingBook = bookRepository.findById(id)
                .orElseThrow(() -> new BookNotFoundException("Book not found with ID: " + id));
        existingBook.setTitle(bookDTO.getTitle());
        existingBook.setAuthor(bookDTO.getAuthor());
        existingBook.setPublicationYear(bookDTO.getPublicationYear());
        existingBook.setIsbn(bookDTO.getIsbn());
        Book updatedBook = bookRepository.save(existingBook);
        return bookMapper.toDTO(updatedBook);
    }

    @CacheEvict(value = "books", key = "#id")
    public Boolean deleteBook(Long id) {
        bookRepository.deleteById(id);
        return true;
    }
}
