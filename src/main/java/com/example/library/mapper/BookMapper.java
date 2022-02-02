package com.example.library.mapper;

import com.example.library.dto.BookRequest;
import com.example.library.model.Book;
import org.springframework.stereotype.Component;

@Component
public class BookMapper {

    public Book mapToBookEntity(BookRequest request) {
        Book book = new Book();
        book.setTitle(request.getTitle());
        book.setReleaseDate(request.getReleaseDate());
        return book;
    }
}
