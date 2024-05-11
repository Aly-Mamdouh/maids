package com.maids.task.service.impl;

import com.maids.task.mapper.BorrowingRecordMapper;
import com.maids.task.model.Book;
import com.maids.task.model.BorrowingRecord;
import com.maids.task.model.Patron;
import com.maids.task.repo.BookRepository;
import com.maids.task.repo.BorrowingRecordRepository;
import com.maids.task.repo.PatronRepository;
import com.maids.task.service.BorrowingRecordService;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.time.LocalDate;

@Service
@RequiredArgsConstructor
public class BorrowingRecordServiceImpl implements BorrowingRecordService {

     BorrowingRecordRepository borrowingRecordRepository;
     BookRepository bookRepository;
     PatronRepository patronRepository;

    @Transactional
    public Boolean borrowBook(Long bookId, Long patronId) {
        Book book = bookRepository.findById(bookId)
                .orElseThrow(() -> new RuntimeException("Book not found with id: " + bookId));
        Patron patron = patronRepository.findById(patronId)
                .orElseThrow(() -> new RuntimeException("Patron not found with id: " + patronId));

        BorrowingRecord borrowingRecord = new BorrowingRecord();
        borrowingRecord.setBook(book);
        borrowingRecord.setPatron(patron);
        borrowingRecord.setBorrowingDate(LocalDate.now());

        borrowingRecordRepository.save(borrowingRecord);

        return true;
    }

    @Transactional
    public Boolean returnBook(Long bookId, Long patronId) {
        Book book = bookRepository.findById(bookId)
                .orElseThrow(() -> new RuntimeException("Book not found with id: " + bookId));
        Patron patron = patronRepository.findById(patronId)
                .orElseThrow(() -> new RuntimeException("Patron not found with id: " + patronId));

        BorrowingRecord borrowingRecord = borrowingRecordRepository.findBorrowingRecordByBookAndPatron(book, patron)
                .orElseThrow(() -> new RuntimeException("Borrowing record not found for book and patron"));

        borrowingRecord.setReturnDate(LocalDate.now());

        borrowingRecordRepository.save(borrowingRecord);

        return true;
    }
}
