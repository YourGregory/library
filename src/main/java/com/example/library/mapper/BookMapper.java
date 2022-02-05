package com.example.library.mapper;

import com.example.library.dto.BookRequest;
import com.example.library.dto.SimpleBook;
import com.example.library.model.Book;
import org.springframework.stereotype.Component;

import java.util.ArrayList;
import java.util.List;
import java.util.Set;

@Component
public class BookMapper {

    public Book mapToBookEntity(BookRequest request) {
        Book book = new Book();
        updateBooksField(book, request);

        return book;
    }

    public Book updateBooksField(Book book, BookRequest request) {
        book.setTitle(request.getTitle());
        book.setReleaseDate(request.getReleaseDate());

        return book;
    }

    /*
        Method to obtain books only with author name, instead of full author.
        Is used in GetMapping, because author contains books, and books contain author.
        At the end there was an infinite loop when service tired to obtain book for author
         and then book for author.
         In order to prevent StackOverflow Exception we should get list of books only with author name.
     */
    public SimpleBook toSimpleBook(Book book) {
        SimpleBook simpleBook = new SimpleBook();

        simpleBook.setId(book.getId());
        simpleBook.setTitle(book.getTitle());
        simpleBook.setReleaseDate(book.getReleaseDate());
        simpleBook.setAuthorName(book.getAuthor().getName());

        return simpleBook;
    }

    public List<SimpleBook> toSimpleBooksList(Set<Book> booksList) {
        List<SimpleBook> simpleBooksList = new ArrayList<>();
        for (Book book: booksList) {
            SimpleBook simpleBook = toSimpleBook(book);
            simpleBooksList.add(simpleBook);
        }
        return simpleBooksList;
    }
}
