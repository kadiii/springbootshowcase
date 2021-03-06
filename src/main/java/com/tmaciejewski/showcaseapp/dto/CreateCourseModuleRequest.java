package com.tmaciejewski.showcaseapp.dto;

import javax.validation.constraints.NotNull;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class CreateCourseModuleRequest {

    @NotNull
    private String name;
    private String description;
}
