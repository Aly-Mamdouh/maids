package com.maids.task.service;

import com.maids.task.dtos.PatronDTO;
import org.springframework.stereotype.Service;

import java.util.List;

public interface PatronService {
    List<PatronDTO> getAllPatrons();
    PatronDTO getPatronById(Long id);
    PatronDTO savePatron(PatronDTO patronDTO);
    PatronDTO updatePatron(Long id, PatronDTO patronDTO);
    Boolean deletePatron(Long id);
}
