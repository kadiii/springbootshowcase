package com.tmaciejewski.showcaseapp.controllers;

import com.tmaciejewski.showcaseapp.model.Course;
import com.tmaciejewski.showcaseapp.repositories.CourseRepository;
import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class CourseController {
    
    @Autowired
    CourseRepository courseRepository;
    
    @GetMapping("/create")
    public Course createCourse() {
        return courseRepository.save(Course.builder().name("testowy").build());
    }
    
    @GetMapping("/load")
    public List<Course> loadCourses() {
        return courseRepository.findAll();
    }
}
