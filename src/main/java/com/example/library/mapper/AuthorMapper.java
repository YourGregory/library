package com.example.library.mapper;

import com.example.library.dto.AuthorRequest;
import com.example.library.model.Author;
import org.springframework.stereotype.Component;

@Component
public class AuthorMapper {

    public Author toAuthor(AuthorRequest request) {
        Author author = new Author();
        author.setName(request.getName());

        return author;
    }
}
