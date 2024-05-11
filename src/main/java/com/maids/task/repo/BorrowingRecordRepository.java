package com.maids.task.repo;

import com.maids.task.model.Book;
import com.maids.task.model.BorrowingRecord;
import com.maids.task.model.Patron;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.Optional;

@Repository
public interface BorrowingRecordRepository extends JpaRepository<BorrowingRecord,Long> {

    Optional<BorrowingRecord> findBorrowingRecordByBookAndPatron(Book book, Patron patron);
}
