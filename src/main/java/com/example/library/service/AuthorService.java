package com.example.library.service;

import com.example.library.dto.AuthorRequest;
import com.example.library.dto.SimpleAuthor;
import com.example.library.exception.ResourceNotFoundException;
import com.example.library.mapper.AuthorMapper;
import com.example.library.model.Author;
import com.example.library.repository.AuthorRepository;
import com.example.library.repository.BookRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import java.util.List;

@RequiredArgsConstructor
@Service
public class AuthorService {

    private final BookRepository bookRepository;

    private final AuthorRepository repository;

    private final AuthorMapper authorMapper;

    @PersistenceContext
    private final EntityManager entityManager;

    @Transactional
    public Long createAuthor(AuthorRequest request) {

        Author author = authorMapper.toAuthor(request);

        Author savedAuthor = repository.save(author);

        return savedAuthor.getId();
    }

    @Transactional(readOnly = true)
    public List<SimpleAuthor> getAll() {
        List<Author> authorsList = repository.findAll();
        return authorMapper.toSimpleAuthorsList(authorsList);
    }

    @Transactional(readOnly = true)
    public SimpleAuthor findSimpleAuthorById(Long id) {
        Author author = findById(id);

        return authorMapper.toSimpleAuthor(author);
    }

    @Transactional(readOnly = true)
    public Author findById(Long id) {
        return repository.findById(id)
                .orElseThrow(() -> new ResourceNotFoundException("Author not found with id: ", id));
    }

    @Transactional
    public Long updateAuthor(Long id, AuthorRequest request) {
        Author author = findById(id);
        authorMapper.updateAuthorsField(author, request);
        repository.save(author);

        return author.getId();
    }

    @Transactional
    public Long deleteAuthor(Long id) {

        Author author = findById(id);

        bookRepository.deleteAll(author.getBooks());

        repository.delete(author);

        return id;
    }

    @Transactional(readOnly = true)
    public String findNameById(Long id) {
        String name = repository.findNameById(id).get();
        System.out.println(name);
        System.out.println("here");
        return name;
    }
}
