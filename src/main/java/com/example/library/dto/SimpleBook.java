package com.example.library.dto;

import lombok.Getter;
import lombok.Setter;
import java.time.LocalDate;

@Getter
@Setter
public class
SimpleBook {

    private Long id;

    private String title;

    private LocalDate releaseDate;

    private SimpleAuthor author;
}
