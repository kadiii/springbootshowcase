package com.tmaciejewski.showcaseapp.dto;

import java.io.Serializable;
import javax.validation.constraints.NotNull;
import lombok.Getter;
import lombok.Setter;

@Setter
@Getter
public class CreateLecturerRequest implements Serializable {

    @NotNull
    private String firstName;
    @NotNull
    private String lastName;

}
