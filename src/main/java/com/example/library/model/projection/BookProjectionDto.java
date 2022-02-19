package com.example.library.model.projection;

import lombok.Getter;
import lombok.Setter;

@Getter
public class BookProjectionDto {

    private String title;
    private long id;

    public BookProjectionDto(Long id, String title) {
        this.title = title;
        this.id = id;
    }

    public BookProjectionDto() {}
}
