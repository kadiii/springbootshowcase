package com.tmaciejewski.showcaseapp.services;

import com.tmaciejewski.showcaseapp.dto.AddLecturerRequest;
import com.tmaciejewski.showcaseapp.dto.UpdateCourseModuleRequest;
import com.tmaciejewski.showcaseapp.dto.UpdateCourseModuleResponse;
import com.tmaciejewski.showcaseapp.exceptions.ResourceNotFoundException;
import com.tmaciejewski.showcaseapp.model.CourseModule;
import com.tmaciejewski.showcaseapp.model.Lecturer;
import com.tmaciejewski.showcaseapp.repositories.CourseModuleRepository;
import com.tmaciejewski.showcaseapp.repositories.CourseRepository;
import com.tmaciejewski.showcaseapp.repositories.LecturerRepository;
import ma.glasnost.orika.MapperFacade;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class CourseModuleUpdaterImpl implements CourseModuleUpdater {

    @Autowired
    LecturerRepository lecturerRepository;

    @Autowired
    CourseModuleRepository courseModuleRepository;

    @Autowired
    CourseRepository courseRepository;

    @Autowired
    MapperFacade mapper;

    @Override
    public void addLecturerToCourseModule(Long courseModuleId, AddLecturerRequest addLecturerRequest) {
        Lecturer lecturer = lecturerRepository.findById(addLecturerRequest.getLecturerId()).
                orElseThrow(() -> new ResourceNotFoundException("Lecturer not found"));

        courseModuleRepository.findById(courseModuleId).map(courseModule -> {
            courseModule.setLecturer(lecturer);
            return courseModuleRepository.save(courseModule);
        }).orElseThrow(() -> new ResourceNotFoundException("Course module not found"));
    }

    @Override
    public UpdateCourseModuleResponse updateCourseModule(Long courseId, Long courseModuleId, UpdateCourseModuleRequest updateCourseModuleRequest) {
        if (!courseRepository.existsById(courseId)) {
            throw new ResourceNotFoundException("Course not found");
        }

        return courseModuleRepository.findById(courseModuleId).map(courseModule -> {
            CourseModule courseModuleToUpdate = mapper.map(updateCourseModuleRequest, CourseModule.class);
            courseModuleToUpdate.setId(courseModuleId);
            return mapper.map(courseModuleRepository.save(courseModuleToUpdate), UpdateCourseModuleResponse.class);
        }).orElseThrow(() -> new ResourceNotFoundException("Course module not found"));
    }

}
