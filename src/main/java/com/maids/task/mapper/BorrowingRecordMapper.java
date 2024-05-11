package com.maids.task.mapper;

import com.maids.task.dtos.BorrowingRecordDTO;
import com.maids.task.model.BorrowingRecord;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;


@Mapper(componentModel = "spring")
public interface BorrowingRecordMapper {

    BorrowingRecordDTO toDTO(BorrowingRecord borrowingRecord);

    BorrowingRecord toEntity(BorrowingRecordDTO borrowingRecordDTO);

}