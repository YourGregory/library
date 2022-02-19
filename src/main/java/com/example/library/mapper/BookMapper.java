package com.example.library.mapper;

import com.example.library.dto.BookRequest;
import com.example.library.dto.SimpleBook;
import com.example.library.model.Book;
import lombok.RequiredArgsConstructor;
import org.mapstruct.Mapper;
import org.springframework.stereotype.Component;

import java.util.ArrayList;
import java.util.List;
import java.util.Set;

@Component
@RequiredArgsConstructor
public class BookMapper {

    private final AuthorMapper authorMapper;
    private final BookMapperMapStructImpl mapperStruct;

    public Book mapToBookEntity(BookRequest request) {
        Book book = new Book();
        updateBooksField(book, request);

        return book;
    }

    public void updateBooksField(Book book, BookRequest request) {
        book.setTitle(request.getTitle());
        book.setReleaseDate(request.getReleaseDate());
    }

    public SimpleBook toSimpleBook(Book book) {
        SimpleBook simpleBook = new SimpleBook();

        simpleBook.setId(book.getId());
        simpleBook.setTitle(book.getTitle());
        simpleBook.setReleaseDate(book.getReleaseDate());
        simpleBook.setAuthor(authorMapper.toSimpleAuthor(book.getAuthor()));

        return simpleBook;
    }

    public List<SimpleBook> toSimpleBooksList(Set<Book> booksList) {
        List<SimpleBook> simpleBooksList = new ArrayList<>();
        for (Book book : booksList) {
            SimpleBook simpleBook = toSimpleBook(book);
            simpleBooksList.add(simpleBook);
        }
        return simpleBooksList;
    }
}
