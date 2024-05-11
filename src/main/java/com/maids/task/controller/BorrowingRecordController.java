package com.maids.task.controller;

import com.maids.task.service.BorrowingRecordService;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;


@RestController
@RequestMapping("/borrowing-record")
@RequiredArgsConstructor
@Api(tags = "Borrowing Record")
public class BorrowingRecordController {

    BorrowingRecordService borrowingRecordService;


    @PostMapping(value = "/{book_id}/{patron_id}")
    @ApiOperation("Borrow Book")
    public ResponseEntity<Boolean> borrowBook(@PathVariable("book_id") Long bookId,
                                                 @PathVariable("patron_id") Long patronId) {
         borrowingRecordService.borrowBook(bookId,patronId);
        return ResponseEntity.ok(true);
    }

    @PutMapping(value = "/{book_id}/{patron_id}")
    @ApiOperation("Return Book")
    public ResponseEntity<Boolean> returnBook(@PathVariable("book_id") Long bookId,
                                              @PathVariable("patron_id") Long patronId) {
        borrowingRecordService.returnBook(bookId,patronId);
        return ResponseEntity.ok(true);
    }

}
