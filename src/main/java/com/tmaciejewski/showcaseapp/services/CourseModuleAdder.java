package com.tmaciejewski.showcaseapp.services;

import com.tmaciejewski.showcaseapp.dto.CreateCourseModuleRequest;
import com.tmaciejewski.showcaseapp.dto.CreateCourseModuleResponse;

public interface CourseModuleAdder {

    CreateCourseModuleResponse createCourseModule(Long courseId, CreateCourseModuleRequest createCourseModuleRequest);
}
