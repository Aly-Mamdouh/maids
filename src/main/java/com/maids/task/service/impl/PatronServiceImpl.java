package com.maids.task.service.impl;

import com.maids.task.dtos.PatronDTO;
import com.maids.task.exception.BookDuplicateIDException;
import com.maids.task.exception.BookNotFoundException;
import com.maids.task.exception.PatronNotFoundException;
import com.maids.task.mapper.PatronMapper;
import com.maids.task.model.Patron;
import com.maids.task.repo.PatronRepository;
import com.maids.task.service.PatronService;
import lombok.RequiredArgsConstructor;
import org.springframework.cache.annotation.CacheEvict;
import org.springframework.cache.annotation.Cacheable;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;

@Service
@RequiredArgsConstructor
public class PatronServiceImpl implements PatronService {

     PatronRepository patronRepository;
     PatronMapper patronMapper;

    @Cacheable("patrons")
    public List<PatronDTO> getAllPatrons() {
        List<Patron> patrons = patronRepository.findAll();
        return patrons.stream()
                .map(patronMapper::toDTO)
                .collect(Collectors.toList());
    }

    @Cacheable(value = "patrons", key = "#id")
    public PatronDTO getPatronById(Long id) {
        Patron patron = patronRepository.findById(id)
                .orElseThrow(() -> new PatronNotFoundException("Patron not found with ID: " + id));
        return patronMapper.toDTO(patron);
    }

    @CacheEvict(value = "patrons", allEntries = true)
    public PatronDTO savePatron(PatronDTO patronDTO) {
        if(patronRepository.existsById(patronDTO.getId())){
        Patron patron = patronMapper.toEntity(patronDTO);
        Patron savedPatron = patronRepository.save(patron);
        return patronMapper.toDTO(savedPatron);
    }else{
        throw new BookDuplicateIDException("OOPS Patron With ID: "+ patronDTO.getId()+" Is Duplicated");
    }
    }

    @CacheEvict(value = "patrons", key = "#id")
    public PatronDTO updatePatron(Long id, PatronDTO patronDTO) {
        Patron existingPatron = patronRepository.findById(id)
                .orElseThrow(() -> new PatronNotFoundException("Patron not found with ID: " + id));
        existingPatron.setName(patronDTO.getName());
        existingPatron.setContactInformation(patronDTO.getContactInformation());
        Patron updatedPatron = patronRepository.save(existingPatron);
        return patronMapper.toDTO(updatedPatron);
    }

    @CacheEvict(value = "patrons", key = "#id")
    public Boolean deletePatron(Long id) {
        patronRepository.deleteById(id);
        return true;
    }

}
