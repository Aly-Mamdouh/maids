package com.maids.task.controller;

import com.maids.task.dtos.PatronDTO;
import com.maids.task.service.PatronService;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/patron")
@RequiredArgsConstructor
@Api(tags = "Patron")
public class PatronController {

    PatronService patronService;


    @GetMapping
    @ApiOperation("Get All Patrons")
    public ResponseEntity<List<PatronDTO>> getAllPatrons() {
        List<PatronDTO> patrons = patronService.getAllPatrons();
        return ResponseEntity.ok(patrons);
    }

    @GetMapping("/{id}")
    @ApiOperation("Get Patron By ID")
    public ResponseEntity<PatronDTO> getPatronById(@PathVariable Long id) {
        PatronDTO patron = patronService.getPatronById(id);
        return ResponseEntity.ok(patron);
    }

    @PostMapping
    @ApiOperation("Add Patron")
    public ResponseEntity<PatronDTO> addPatron(@RequestBody PatronDTO patronDTO) {
        PatronDTO savePatron = patronService.savePatron(patronDTO);
        return ResponseEntity.status(HttpStatus.CREATED).body(savePatron);
    }

    @PutMapping("/{id}")
    @ApiOperation("Update Patron")
    public ResponseEntity<PatronDTO> updatePatron(@PathVariable Long id, @RequestBody PatronDTO patronDTO) {
        PatronDTO updatePatron = patronService.updatePatron(id, patronDTO);
        return ResponseEntity.ok(updatePatron);
    }

    @DeleteMapping("/{id}")
    @ApiOperation("Delete Patron")
    public ResponseEntity<Boolean> deletePatron(@PathVariable Long id) {
        patronService.deletePatron(id);
        return ResponseEntity.ok(true);
    }
}
