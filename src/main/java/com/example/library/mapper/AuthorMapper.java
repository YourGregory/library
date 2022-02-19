package com.example.library.mapper;

import com.example.library.dto.AuthorRequest;
import com.example.library.dto.SimpleAuthor;
import com.example.library.model.Author;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Component;

import java.util.ArrayList;
import java.util.List;

@Component
public class AuthorMapper {


    public Author toAuthor(AuthorRequest request) {
        Author author = new Author();
        updateAuthorsField(author, request);

        return author;
    }

    public void updateAuthorsField(Author author, AuthorRequest request) {
        author.setName(request.getName());
    }

    public List<SimpleAuthor> toSimpleAuthorsList(List<Author> authorsList) {
        List<SimpleAuthor> simpleAuthorsList = new ArrayList<>();
        authorsList.forEach(author -> {
            SimpleAuthor simpleAuthor = toSimpleAuthor(author);
            simpleAuthorsList.add(simpleAuthor);
        });
        return simpleAuthorsList;
    }

    public SimpleAuthor toSimpleAuthor(Author author) {
        SimpleAuthor simpleAuthor = new SimpleAuthor();

        simpleAuthor.setId(author.getId());
        simpleAuthor.setName(author.getName());

        return simpleAuthor;
    }
}
