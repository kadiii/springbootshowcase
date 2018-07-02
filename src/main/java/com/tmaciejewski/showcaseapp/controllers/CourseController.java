package com.tmaciejewski.showcaseapp.controllers;

import com.tmaciejewski.showcaseapp.dto.CreateCourseRequest;
import com.tmaciejewski.showcaseapp.dto.CreateCourseResponse;
import com.tmaciejewski.showcaseapp.dto.UpdateCourseRequest;
import com.tmaciejewski.showcaseapp.dto.UpdateCourseResponse;
import com.tmaciejewski.showcaseapp.exceptions.ResourceNotFoundException;
import com.tmaciejewski.showcaseapp.model.Course;
import com.tmaciejewski.showcaseapp.repositories.CourseRepository;
import com.tmaciejewski.showcaseapp.services.CourseAdder;
import com.tmaciejewski.showcaseapp.services.CourseUpdater;
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

@Api(value = "Courses", description = "Endpoint for course CRUD", tags = { "Courses" })
@RestController
@RequestMapping("/courses")
public class CourseController {

    @Autowired
    CourseRepository courseRepository;
    
    @Autowired
    CourseUpdater courseUpdater;
    
    @Autowired
    CourseAdder courseAdder;

    @PostMapping
    @ResponseStatus(HttpStatus.CREATED)
    public CreateCourseResponse createCourse(@RequestBody CreateCourseRequest createCourseRequest) {
        return courseAdder.createCourse(createCourseRequest);
    }
    
    @PutMapping("/{courseId}")
    public UpdateCourseResponse updateCourse(@PathVariable Long courseId, @RequestBody UpdateCourseRequest updateCourseRequest) {
        return courseUpdater.updateCourse(courseId, updateCourseRequest);
    }

    @GetMapping
    public List<Course> loadAllCourses() {
        return courseRepository.findAll();
    }

    @GetMapping("/{courseId}")
    public Course loadCourseById(@PathVariable("courseId") Long courseId) {
        return courseRepository.findById(courseId)
                .orElseThrow(() -> new ResourceNotFoundException("Course not found"));
    }

    @DeleteMapping("/{courseId}")
    public ResponseEntity<?> deleteCourseById(@PathVariable("courseId") Long courseId) {
        return courseRepository.findById(courseId).map(course -> {
            courseRepository.delete(course);
            return ResponseEntity.ok().build();
        }).orElseThrow(() -> new ResourceNotFoundException("Course not found"));
    }
}
