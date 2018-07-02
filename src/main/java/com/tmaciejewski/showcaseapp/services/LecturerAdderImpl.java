package com.tmaciejewski.showcaseapp.services;

import com.tmaciejewski.showcaseapp.dto.CreateLecturerRequest;
import com.tmaciejewski.showcaseapp.dto.CreateLecturerResponse;
import com.tmaciejewski.showcaseapp.model.Lecturer;
import com.tmaciejewski.showcaseapp.repositories.LecturerRepository;
import ma.glasnost.orika.MapperFacade;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class LecturerAdderImpl implements LecturerAdder {

    @Autowired
    LecturerRepository lecturerRepository;

    @Autowired
    MapperFacade mapper;

    @Override
    public CreateLecturerResponse createLecturer(CreateLecturerRequest createLecturerRequest) {
        return mapper.map(lecturerRepository.save(mapper.map(createLecturerRequest, Lecturer.class)), CreateLecturerResponse.class);
    }

}
