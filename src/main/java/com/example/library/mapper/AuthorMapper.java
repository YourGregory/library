package com.example.library.mapper;

import com.example.library.dto.AuthorRequest;
import com.example.library.dto.SimpleAuthor;
import com.example.library.model.Author;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Component;

import java.util.ArrayList;
import java.util.List;

@Component
@RequiredArgsConstructor
public class AuthorMapper {

    private final BookMapper bookMapper;

    public Author toAuthor(AuthorRequest request) {
        Author author = new Author();
        updateAuthorsField(author, request);

        return author;
    }

    public Author updateAuthorsField(Author author, AuthorRequest request) {
        author.setName(request.getName());

        return author;
    }

    public List<SimpleAuthor> toSimpleAuthorsList(List<Author> authorsList) {
        List<SimpleAuthor> simpleAuthorsList = new ArrayList<>();
        for (Author author : authorsList) {
            SimpleAuthor simpleAuthor = toSimpleAuthor(author);
            simpleAuthorsList.add(simpleAuthor);
        }
        return simpleAuthorsList;
    }

    public SimpleAuthor toSimpleAuthor(Author author) {
        SimpleAuthor simpleAuthor = new SimpleAuthor();

        simpleAuthor.setId(author.getId());
        simpleAuthor.setName(author.getName());
        simpleAuthor.setBooks(bookMapper.toSimpleBooksList(author.getBook()));

        return simpleAuthor;
    }
}
