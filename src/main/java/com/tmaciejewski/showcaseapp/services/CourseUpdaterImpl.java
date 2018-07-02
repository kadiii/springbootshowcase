package com.tmaciejewski.showcaseapp.services;

import com.tmaciejewski.showcaseapp.dto.UpdateCourseRequest;
import com.tmaciejewski.showcaseapp.dto.UpdateCourseResponse;
import com.tmaciejewski.showcaseapp.exceptions.ResourceNotFoundException;
import com.tmaciejewski.showcaseapp.model.Course;
import com.tmaciejewski.showcaseapp.repositories.CourseRepository;
import ma.glasnost.orika.MapperFacade;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class CourseUpdaterImpl implements CourseUpdater {
    
    @Autowired
    CourseRepository courseRepository;
    
    @Autowired
    MapperFacade mapper;

    @Override
    public UpdateCourseResponse updateCourse(Long courseId, UpdateCourseRequest updateCourseRequest) {
        return courseRepository.findById(courseId).map(course -> {
            Course courseToUpdate = mapper.map(updateCourseRequest, Course.class);
            courseToUpdate.setId(courseId);
            return mapper.map(courseRepository.save(courseToUpdate), UpdateCourseResponse.class);
        }).orElseThrow(() -> new ResourceNotFoundException("Course not found"));
    }
    
}
