package com.example.library.service;

import com.example.library.dto.BookRequest;
import com.example.library.exception.ResourceNotFoundException;
import com.example.library.mapper.BookMapper;
import com.example.library.model.Author;
import com.example.library.model.Book;
import com.example.library.repository.AuthorRepository;
import com.example.library.repository.BookRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
public class BookService {

    private final BookRepository bookRepository;
    private final AuthorRepository authorRepository;
    private final BookMapper bookMapper;

    public Long createBook(BookRequest request) {

        Book book = bookMapper.mapToBookEntity(request);

        saveBookAuthor(request, book);

        Book savedBook = bookRepository.save(book);

        return savedBook.getId();
    }

    private void saveBookAuthor(BookRequest request, Book book) {
        Author author = authorRepository.findById(request.getAuthorId())
                .orElseThrow(() -> new ResourceNotFoundException("Author not found with id: ", request.getAuthorId()));
        book.setAuthor(author);
    }
}
