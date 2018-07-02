package com.tmaciejewski.showcaseapp.dto;

import com.tmaciejewski.showcaseapp.enums.StudyMode;
import lombok.Getter;
import lombok.Setter;

@Setter
@Getter
public class UpdateCourseResponse {

    private Long id;
    private String name;
    private String description;
    private StudyMode studyMode;
}
