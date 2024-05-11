package com.maids.task.mapper;

import com.maids.task.dtos.PatronDTO;
import com.maids.task.model.Patron;
import org.mapstruct.Mapper;


@Mapper(componentModel = "spring")
public interface PatronMapper {

    PatronDTO toDTO(Patron patron);

    Patron toEntity(PatronDTO patronDTO);

}