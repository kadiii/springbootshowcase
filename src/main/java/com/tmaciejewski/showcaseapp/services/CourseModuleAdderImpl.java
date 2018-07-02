package com.tmaciejewski.showcaseapp.services;

import com.tmaciejewski.showcaseapp.dto.CreateCourseModuleRequest;
import com.tmaciejewski.showcaseapp.dto.CreateCourseModuleResponse;
import com.tmaciejewski.showcaseapp.exceptions.ResourceNotFoundException;
import com.tmaciejewski.showcaseapp.model.CourseModule;
import com.tmaciejewski.showcaseapp.repositories.CourseModuleRepository;
import com.tmaciejewski.showcaseapp.repositories.CourseRepository;
import ma.glasnost.orika.MapperFacade;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class CourseModuleAdderImpl implements CourseModuleAdder {

    @Autowired
    CourseRepository courseRepository;

    @Autowired
    CourseModuleRepository courseModuleRepository;

    @Autowired
    MapperFacade mapper;

    @Override
    public CreateCourseModuleResponse createCourseModule(Long courseId, CreateCourseModuleRequest createCourseModuleRequest) {
        return courseRepository.findById(courseId).map(course -> {
            CourseModule courseModuleToAdd = mapper.map(createCourseModuleRequest, CourseModule.class);
            courseModuleToAdd.setCourse(course);
            return mapper.map(courseModuleRepository.save(courseModuleToAdd), CreateCourseModuleResponse.class);
        }).orElseThrow(() -> new ResourceNotFoundException("Course not found"));
    }

}
