package com.example.library.service;

import com.example.library.dto.AuthorRequest;
import com.example.library.dto.SimpleAuthor;
import com.example.library.exception.ResourceNotFoundException;
import com.example.library.mapper.AuthorMapper;
import com.example.library.model.Author;
import com.example.library.model.Book;
import com.example.library.repository.AuthorRepository;
import com.example.library.repository.BookRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;

@RequiredArgsConstructor
@Service
public class AuthorService {

    private final BookRepository bookRepository;
    private final AuthorRepository repository;
    private final AuthorMapper authorMapper;

    public Long createAuthor(AuthorRequest request) {

        Author author = authorMapper.toAuthor(request);

        Author savedAuthor = repository.save(author);

        return savedAuthor.getId();
    }

    public List<SimpleAuthor> getAll() {
        List<Author> authorsList = repository.findAll();
        return authorMapper.toSimpleAuthorsList(authorsList);
    }

    public SimpleAuthor findSimpleAuthorById(Long id) {
        Author author = findById(id);
        SimpleAuthor simpleAuthor = authorMapper.toSimpleAuthor(author);

        return simpleAuthor;
    }

    public Author findById(Long id) {
        return repository.findById(id)
                .orElseThrow(() -> new ResourceNotFoundException("Author not found with id: ", id));
    }

    public Long updateAuthor(Long id, AuthorRequest request) {
        Author author = findById(id);
        authorMapper.updateAuthorsField(author, request);
        repository.save(author);

        return author.getId();
    }

    public Long deleteAuthor(Long id) {

        Author author = findById(id);

        for (Book book : author.getBook()) {
            bookRepository.delete(book);
        }

        repository.delete(author);

        return id;
    }
}
