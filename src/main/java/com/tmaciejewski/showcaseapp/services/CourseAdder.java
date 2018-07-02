package com.tmaciejewski.showcaseapp.services;

import com.tmaciejewski.showcaseapp.dto.CreateCourseRequest;
import com.tmaciejewski.showcaseapp.dto.CreateCourseResponse;

public interface CourseAdder {
 
    CreateCourseResponse createCourse(CreateCourseRequest courseRequest);
}
