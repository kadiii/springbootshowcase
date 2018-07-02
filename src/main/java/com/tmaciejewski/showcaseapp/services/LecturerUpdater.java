package com.tmaciejewski.showcaseapp.services;

import com.tmaciejewski.showcaseapp.dto.UpdateLecturerRequest;
import com.tmaciejewski.showcaseapp.dto.UpdateLecturerResponse;

public interface LecturerUpdater {
    UpdateLecturerResponse updateLecturer(Long lecturerId, UpdateLecturerRequest updateLecturerRequest);
}
