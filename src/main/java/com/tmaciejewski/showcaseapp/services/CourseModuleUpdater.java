package com.tmaciejewski.showcaseapp.services;

import com.tmaciejewski.showcaseapp.dto.AddLecturerRequest;
import com.tmaciejewski.showcaseapp.dto.UpdateCourseModuleRequest;
import com.tmaciejewski.showcaseapp.dto.UpdateCourseModuleResponse;

public interface CourseModuleUpdater {

    void addLecturerToCourseModule(Long courseModuleId, AddLecturerRequest addLecturerRequest);

    UpdateCourseModuleResponse updateCourseModule(Long courseId, Long courseModuleId, UpdateCourseModuleRequest updateCourseModuleRequest);
}
