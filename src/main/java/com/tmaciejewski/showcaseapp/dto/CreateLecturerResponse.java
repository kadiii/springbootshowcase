package com.tmaciejewski.showcaseapp.dto;

import java.io.Serializable;
import lombok.Getter;
import lombok.Setter;

@Setter
@Getter
public class CreateLecturerResponse implements Serializable {

    private String id;
    private String firstName;
    private String lastName;

}
