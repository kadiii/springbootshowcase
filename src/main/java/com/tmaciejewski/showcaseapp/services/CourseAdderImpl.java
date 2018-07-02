package com.tmaciejewski.showcaseapp.services;

import com.tmaciejewski.showcaseapp.dto.CreateCourseRequest;
import com.tmaciejewski.showcaseapp.dto.CreateCourseResponse;
import com.tmaciejewski.showcaseapp.model.Course;
import com.tmaciejewski.showcaseapp.repositories.CourseRepository;
import ma.glasnost.orika.MapperFacade;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class CourseAdderImpl implements CourseAdder {
    
    @Autowired
    CourseRepository courseRepository; 
    
    @Autowired
    MapperFacade mapper;

    @Override
    public CreateCourseResponse createCourse(CreateCourseRequest courseRequest) {
         return mapper.map(courseRepository.save(mapper.map(courseRequest, Course.class)), CreateCourseResponse.class);
    }
    
}
