package com.tmaciejewski.showcaseapp.dto;

import javax.validation.constraints.NotNull;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class UpdateLecturerRequest {
    
    @NotNull
    private String firstName;
    @NotNull
    private String lastName;
}
