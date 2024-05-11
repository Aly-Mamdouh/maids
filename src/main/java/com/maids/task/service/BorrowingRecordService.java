package com.maids.task.service;

import org.springframework.stereotype.Service;

public interface BorrowingRecordService {
    Boolean borrowBook(Long bookId, Long patronId);
    Boolean returnBook(Long bookId, Long patronId);
}
