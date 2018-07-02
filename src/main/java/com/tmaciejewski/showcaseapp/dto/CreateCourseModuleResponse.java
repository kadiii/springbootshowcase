package com.tmaciejewski.showcaseapp.dto;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class CreateCourseModuleResponse {

    private Long id;
    private String name;
    private String description;
}
