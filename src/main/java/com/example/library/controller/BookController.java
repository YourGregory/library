package com.example.library.controller;

import com.example.library.dto.BookRequest;
import com.example.library.dto.SimpleBook;
import com.example.library.service.BookService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import javax.validation.Valid;
import java.util.List;

@Validated
@RestController
@RequestMapping("api/book")
@RequiredArgsConstructor
public class BookController {

    private final BookService service;

    @PostMapping
    public ResponseEntity<Long> createBook(@Valid @RequestBody BookRequest request) {

        return ResponseEntity.ok(service.createBook(request));
    }

    @GetMapping
    public ResponseEntity<List<SimpleBook>> getAllBooks() {
        return ResponseEntity.ok(service.getAll());
    }

    @GetMapping(path = "/{id}")
    public SimpleBook getBookById(@PathVariable Long id) {
        return service.findSimpleBookById(id);
    }

    @PutMapping("/{id}")
    public ResponseEntity<Long> updateBook(@PathVariable Long id,
                                           @Valid @RequestBody BookRequest request) {
        return ResponseEntity.ok(service.updateBook(id, request));
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Long> deleteBook(@PathVariable Long id) {
        return ResponseEntity.ok(service.deleteBook(id));
    }
}
