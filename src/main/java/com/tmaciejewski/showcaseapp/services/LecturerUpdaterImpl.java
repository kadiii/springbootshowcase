package com.tmaciejewski.showcaseapp.services;

import com.tmaciejewski.showcaseapp.dto.UpdateLecturerRequest;
import com.tmaciejewski.showcaseapp.dto.UpdateLecturerResponse;
import com.tmaciejewski.showcaseapp.exceptions.ResourceNotFoundException;
import com.tmaciejewski.showcaseapp.model.Lecturer;
import com.tmaciejewski.showcaseapp.repositories.LecturerRepository;
import ma.glasnost.orika.MapperFacade;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class LecturerUpdaterImpl implements LecturerUpdater {
    
    @Autowired
    LecturerRepository lecturerRepository;
    
    @Autowired
    MapperFacade mapper;

    @Override
    public UpdateLecturerResponse updateLecturer(Long lecturerId, UpdateLecturerRequest updateLecturerRequest) {
        return lecturerRepository.findById(lecturerId).map(lecturer -> {
            Lecturer lecturerToUpdate = mapper.map(updateLecturerRequest, Lecturer.class);
            lecturerToUpdate.setId(lecturerId);
            return mapper.map(lecturerRepository.save(lecturerToUpdate), UpdateLecturerResponse.class);
        }).orElseThrow(() -> new ResourceNotFoundException("Lecturer not found"));
    }
    
}
