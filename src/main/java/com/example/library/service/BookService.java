package com.example.library.service;

import com.example.library.dto.BookRequest;
import com.example.library.mapper.BookMapper;
import com.example.library.model.Book;
import com.example.library.repository.BookRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.web.bind.annotation.RequestBody;

@Service
@RequiredArgsConstructor
public class BookService {

    private final BookRepository repository;
    private final BookMapper bookMapper;

    public Long createBook(BookRequest request) {

        Book book = bookMapper.mapToBookEntity(request);

        Book savedBook = repository.save(book);

        return savedBook.getId();
    }
}
