package com.example.library.service;

import com.example.library.dto.BookRequest;
import com.example.library.dto.SimpleBook;
import com.example.library.exception.ResourceNotFoundException;
import com.example.library.mapper.BookMapper;
import com.example.library.model.Author;
import com.example.library.model.Book;
import com.example.library.repository.AuthorRepository;
import com.example.library.repository.BookRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Set;

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

    public List<SimpleBook> getAll() {
        Set<Book> booksList = Set.copyOf(bookRepository.findAll());
        return bookMapper.toSimpleBooksList(booksList);
    }

    public Book findById(Long id) {
        return bookRepository.findById(id)
                .orElseThrow(() -> new ResourceNotFoundException("Book not found with id: ", id));
    }

    public SimpleBook findSimpleBookById(Long id) {
        Book book = findById(id);
        SimpleBook simpleBook = bookMapper.toSimpleBook(book);

        return simpleBook;
    }


    public Long updateBook(Long id, BookRequest request) {
        Book book = findById(id);
        bookMapper.updateBooksField(book, request);
        saveBookAuthor(request, book);
        bookRepository.save(book);

        return book.getId();
    }

    public Long deleteBook(Long id) {
        Book book = findById(id);

        bookRepository.delete(book);

        return id;
    }
}
