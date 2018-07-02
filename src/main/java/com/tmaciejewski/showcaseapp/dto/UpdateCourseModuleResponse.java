package com.tmaciejewski.showcaseapp.dto;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class UpdateCourseModuleResponse {

    private Long id;
    private String name;
    private String description;
}
