package com.tmaciejewski.showcaseapp.repositories;

import com.tmaciejewski.showcaseapp.model.CourseModule;
import java.util.List;
import org.springframework.data.jpa.repository.JpaRepository;

public interface CourseModuleRepository extends JpaRepository<CourseModule, Long> {
    List<CourseModule> findByCourseId(Long courseId);
}