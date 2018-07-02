package com.tmaciejewski.showcaseapp.repositories;

import com.tmaciejewski.showcaseapp.model.Lecturer;
import org.springframework.data.jpa.repository.JpaRepository;

public interface LecturerRepository extends JpaRepository<Lecturer, Long> {
    
}
