package com.maids.task.dtos;

import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.*;

import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotNull;

@Data
@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
public class BookDTO {
    private Long id;
    @NotBlank(message = "Title is required")
    private String title;
    @NotBlank(message = "Author is required")
    private String author;
    @NotNull(message = "Publication year is required")
    @JsonProperty("publication_year")
    private int publicationYear;
    @NotBlank(message = "ISBN is required")
    private String isbn;

    public BookDTO(long l, String s) {
    }
}
