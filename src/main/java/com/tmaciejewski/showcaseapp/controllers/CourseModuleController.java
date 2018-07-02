package com.tmaciejewski.showcaseapp.controllers;

import com.tmaciejewski.showcaseapp.dto.AddLecturerRequest;
import com.tmaciejewski.showcaseapp.dto.CreateCourseModuleRequest;
import com.tmaciejewski.showcaseapp.dto.CreateCourseModuleResponse;
import com.tmaciejewski.showcaseapp.dto.UpdateCourseModuleRequest;
import com.tmaciejewski.showcaseapp.dto.UpdateCourseModuleResponse;
import com.tmaciejewski.showcaseapp.exceptions.ResourceNotFoundException;
import com.tmaciejewski.showcaseapp.model.CourseModule;
import com.tmaciejewski.showcaseapp.repositories.CourseModuleRepository;
import com.tmaciejewski.showcaseapp.repositories.CourseRepository;
import com.tmaciejewski.showcaseapp.services.CourseModuleAdder;
import com.tmaciejewski.showcaseapp.services.CourseModuleUpdater;
import io.swagger.annotations.Api;
import java.util.List;
import javax.validation.Valid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestController;

@Api(value = "Course Modules", description = "Endpoint for course module CRUD", tags = {"Course Modules"})
@RestController
public class CourseModuleController {
    
    @Autowired
    CourseModuleRepository courseModuleRepository;
    
    @Autowired
    CourseRepository courseRepository;
    
    @Autowired
    CourseModuleAdder courseModuleAdder;
    
    @Autowired
    CourseModuleUpdater courseModuleUpdater;

    @GetMapping("/courses/{courseId}/course-modules")
    public List<CourseModule> loadAllCourseModulesByCourseId(@PathVariable("courseId") Long courseId) {
        return courseModuleRepository.findByCourseId(courseId);
    }
    
    @PostMapping("/courses/{courseId}/course-modules")
    public CreateCourseModuleResponse createCourseModule(@PathVariable("courseId") Long courseId,
            @Valid @RequestBody CreateCourseModuleRequest createCourseModuleRequest) {
        return courseModuleAdder.createCourseModule(courseId, createCourseModuleRequest);
    }
    
    @PutMapping("/courses-module/{courseModuleId}/lecturer")
    @ResponseStatus(HttpStatus.NO_CONTENT)
    public void addLecturerToCourseModule(@PathVariable("courseModuleId") Long courseModuleId,
            @Valid @RequestBody AddLecturerRequest addLecturerRequest) {
        courseModuleUpdater.addLecturerToCourseModule(courseModuleId, addLecturerRequest);
    }
    
    @PutMapping("/courses/{courseId}/courseModule/{courseModuleId}")
    public UpdateCourseModuleResponse updateCourseModule(@PathVariable(value = "courseId") Long courseId,
            @PathVariable(value = "courseModuleId") Long courseModuleId,
            @Valid @RequestBody UpdateCourseModuleRequest updateCourseModuleRequest) {
        return courseModuleUpdater.updateCourseModule(courseId, courseModuleId, updateCourseModuleRequest);
    }
    
    @DeleteMapping("/courses/{courseId}/course-modules/{courseModuleId}")
    public ResponseEntity<?> deleteCourseModule(@PathVariable(value = "courseId") Long courseId,
            @PathVariable(value = "courseModuleId") Long courseModuleId) {
        if (!courseRepository.existsById(courseId)) {
            throw new ResourceNotFoundException("Course not found");
        }
        
        return courseModuleRepository.findById(courseModuleId).map(courseModule -> {
            courseModuleRepository.delete(courseModule);
            return ResponseEntity.ok().build();
        }).orElseThrow(() -> new ResourceNotFoundException("Course module not found"));
    }
}
