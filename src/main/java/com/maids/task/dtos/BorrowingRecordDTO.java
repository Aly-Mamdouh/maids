package com.maids.task.dtos;

import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.*;

import java.time.LocalDate;

@Data
@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
public class BorrowingRecordDTO {
    private Long id;
    private BookDTO book;
    private PatronDTO patron;
    @JsonProperty("borrowing_date")
    private LocalDate borrowingDate;
    @JsonProperty("return_date")
    private LocalDate returnDate;
}
