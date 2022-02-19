package com.example.library.repository;

import com.example.library.model.Book;
import com.example.library.model.projection.BookProjection;
import com.example.library.model.projection.BookProjectionDto;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface BookRepository extends JpaRepository<Book, Long> {

    @Query("select b.id as id, b.title as title from Book b")
    List<BookProjection> getBookProjections();

    @Query("select new com.example.library.model.projection.BookProjectionDto(b.id as id, b.title as title)" +
            " from Book b")
    List<BookProjectionDto> getBookProjectionDto();

}
