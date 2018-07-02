package com.tmaciejewski.showcaseapp.dto;

import com.tmaciejewski.showcaseapp.enums.StudyMode;
import javax.validation.constraints.NotNull;
import lombok.Getter;
import lombok.Setter;

@Setter
@Getter
public class UpdateCourseRequest {
    
    @NotNull
    private String name;
    private String description;
    @NotNull
    private StudyMode studyMode;

}
