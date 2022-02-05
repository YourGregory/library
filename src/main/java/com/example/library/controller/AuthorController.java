package com.example.library.controller;

import com.example.library.dto.AuthorRequest;
import com.example.library.dto.SimpleAuthor;
import com.example.library.model.Author;
import com.example.library.service.AuthorService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseStatus;

import javax.validation.Valid;
import java.util.List;

@Controller
@RequiredArgsConstructor
@RequestMapping("api/author")
public class AuthorController {

    private final AuthorService service;

    @PostMapping
    public ResponseEntity<Long> createAuthor(@RequestBody AuthorRequest authorRequest) {
        return ResponseEntity.ok(service.createAuthor(authorRequest));
    }

    @GetMapping
    public ResponseEntity<List<SimpleAuthor>> getAllAuthors() {
        return ResponseEntity.ok(service.getAll());
    }

    @GetMapping(path = "/{id}")
    public ResponseEntity<SimpleAuthor> getAuthorById(@PathVariable Long id) {
        return ResponseEntity.ok(service.findSimpleAuthorById(id));
    }

    @PutMapping("/{id}")
    public ResponseEntity<Long> updateAuthor(@PathVariable Long id,
                                               @Valid @RequestBody AuthorRequest request) {
        return ResponseEntity.ok(service.updateAuthor(id, request));
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Long> deleteAuthor(@PathVariable Long id) {
        return ResponseEntity.ok(service.deleteAuthor(id));
    }
}
