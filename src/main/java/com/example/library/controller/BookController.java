package com.example.library.controller;

import com.example.library.dto.BookRequest;
import com.example.library.service.BookService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("api/book")
@RequiredArgsConstructor
public class BookController {

    private final BookService service;

    @PostMapping
    @ResponseStatus(value = HttpStatus.CREATED)
    public Long createBook(@RequestBody BookRequest request) {
        return service.createBook(request);
    }
}
