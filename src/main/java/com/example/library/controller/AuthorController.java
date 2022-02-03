package com.example.library.controller;

import com.example.library.dto.AuthorRequest;
import com.example.library.service.AuthorService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseStatus;

@Controller
@RequiredArgsConstructor
@RequestMapping("api/author")
public class AuthorController {

    private final AuthorService service;

    @PostMapping
    public ResponseEntity<Long> createAuthor(@RequestBody AuthorRequest authorRequest) {

        return ResponseEntity.ok(service.createAuthor(authorRequest));
    }
}
