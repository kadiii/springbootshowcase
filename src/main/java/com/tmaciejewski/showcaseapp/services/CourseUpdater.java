package com.tmaciejewski.showcaseapp.services;

import com.tmaciejewski.showcaseapp.dto.UpdateCourseRequest;
import com.tmaciejewski.showcaseapp.dto.UpdateCourseResponse;

public interface CourseUpdater {

    UpdateCourseResponse updateCourse(Long courseId, UpdateCourseRequest updateCourseRequest);
}
