package com.example.library.dto;

import lombok.Getter;
import lombok.Setter;

import javax.validation.constraints.NotNull;

@Getter
@Setter
public class AuthorRequest {

    @NotNull(message = "Field is required")
    private String name;
}
