package com.tmaciejewski.showcaseapp.repositories;

import com.tmaciejewski.showcaseapp.model.Course;
import org.springframework.data.jpa.repository.JpaRepository;

public interface CourseRepository extends JpaRepository<Course, Long> {
    
}
