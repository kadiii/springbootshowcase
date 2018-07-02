package com.tmaciejewski.showcaseapp.services;

import com.tmaciejewski.showcaseapp.dto.CreateLecturerRequest;
import com.tmaciejewski.showcaseapp.dto.CreateLecturerResponse;

public interface LecturerAdder {
 
    CreateLecturerResponse createLecturer(CreateLecturerRequest createLecturerRequest);
}
