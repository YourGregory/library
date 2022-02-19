package com.example.library.dto;

import com.example.library.validators.UpperCase;
import lombok.Getter;
import lombok.Setter;

import javax.validation.constraints.NotNull;

@Getter
@Setter
public class AuthorRequest {

    @NotNull(message = "Field is required")
    @UpperCase
    private String name;
}
