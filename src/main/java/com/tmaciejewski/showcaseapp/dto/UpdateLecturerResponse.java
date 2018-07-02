package com.tmaciejewski.showcaseapp.dto;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class UpdateLecturerResponse {
    
    private Long id; 
    private String firstName;
    private String lastName;
}
