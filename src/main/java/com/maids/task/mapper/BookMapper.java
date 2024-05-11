package com.maids.task.mapper;

import com.maids.task.dtos.BookDTO;
import com.maids.task.model.Book;
import org.mapstruct.Mapper;


@Mapper(componentModel = "spring")
public interface BookMapper {

    BookDTO toDTO(Book book);

    Book toEntity(BookDTO bookDTO);

}