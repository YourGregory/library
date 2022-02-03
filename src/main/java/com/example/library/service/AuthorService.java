package com.example.library.service;

import com.example.library.dto.AuthorRequest;
import com.example.library.mapper.AuthorMapper;
import com.example.library.model.Author;
import com.example.library.repository.AuthorRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

@RequiredArgsConstructor
@Service
public class AuthorService {

    private final AuthorRepository repository;
    private final AuthorMapper authorMapper;

    public Long createAuthor(AuthorRequest request) {

        Author author = authorMapper.toAuthor(request);

        Author savedAuthor = repository.save(author);

        return savedAuthor.getId();
    }
}
