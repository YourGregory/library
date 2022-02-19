package com.example.library.repository;

import com.example.library.model.Author;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import java.util.Optional;

@Repository
public interface AuthorRepository extends JpaRepository<Author, Long> {

    @Query("select a.name from Author a where a.id = :id")
    Optional<String> findNameById(@Param("id") Long id);

    @Query(value = "select a.name from author a where a.id = :id", nativeQuery = true)
    Optional<String> findNameByIdNative(@Param("id") Long id);

    Optional<Author> findByName(String name);

    @Modifying
    @Query("update Author set name = :name where id = :id")
    void updateAuthorName(@Param("id") Long id, @Param("name") String name);


}
