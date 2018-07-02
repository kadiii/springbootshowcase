package com.tmaciejewski.showcaseapp.controllers;

import com.tmaciejewski.showcaseapp.dto.CreateLecturerRequest;
import com.tmaciejewski.showcaseapp.dto.CreateLecturerResponse;
import com.tmaciejewski.showcaseapp.dto.UpdateLecturerRequest;
import com.tmaciejewski.showcaseapp.dto.UpdateLecturerResponse;
import com.tmaciejewski.showcaseapp.exceptions.ResourceNotFoundException;
import com.tmaciejewski.showcaseapp.model.Lecturer;
import com.tmaciejewski.showcaseapp.repositories.LecturerRepository;
import com.tmaciejewski.showcaseapp.services.LecturerAdder;
import com.tmaciejewski.showcaseapp.services.LecturerUpdater;
import io.swagger.annotations.Api;
import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestController;

@Api(value = "Lecturers", description = "Endpoint for lecturer CRUD", tags = { "Lecturers" })
@RestController
@RequestMapping("/lecturers")
public class LecturerController {
    
    @Autowired
    LecturerAdder lecturerAdder;
    
    @Autowired
    LecturerUpdater lecturerUpdater;

    @Autowired
    LecturerRepository lecturerRepository;

    @PostMapping
    @ResponseStatus(HttpStatus.CREATED)
    public CreateLecturerResponse createLecturer(@RequestBody CreateLecturerRequest createLecturerRequest) {
        return lecturerAdder.createLecturer(createLecturerRequest);
    }
    
    @PutMapping("/{lecturerId}")
    public UpdateLecturerResponse updateLecturer(@PathVariable Long lecturerId, @RequestBody UpdateLecturerRequest updateLecturerRequest) {
        return lecturerUpdater.updateLecturer(lecturerId, updateLecturerRequest);
    }

    @GetMapping
    public List<Lecturer> loadAllLecturers() {
        return lecturerRepository.findAll();
    }

    @GetMapping("/{lecturerId}")
    public Lecturer loadLecturerById(@PathVariable("lecturerId") Long lecturerId) {
        return lecturerRepository.findById(lecturerId)
                .orElseThrow(() -> new ResourceNotFoundException("Lectuerer not found"));
    }

    @DeleteMapping("/{lecturerId}")
    public ResponseEntity<?> deleteLecturerById(@PathVariable("lecturerId") Long lecturerId) {
        return lecturerRepository.findById(lecturerId).map(lecturer -> {
            lecturerRepository.delete(lecturer);
            return ResponseEntity.ok().build();
        }).orElseThrow(() -> new ResourceNotFoundException("Lecturer not found"));
    }
    
}
