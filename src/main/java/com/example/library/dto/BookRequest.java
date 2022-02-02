package com.example.library.dto;

import lombok.Getter;
import lombok.Setter;

import java.time.LocalDate;

@Getter
@Setter
public class BookRequest {

    private String title;
    private LocalDate releaseDate;
}
