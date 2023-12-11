package com.mkyong.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import com.mkyong.model.Author;

import java.time.LocalDate;
import java.util.List;

// Spring Data JPA creates CRUD implementation at runtime automatically.
public interface AuthorRepository extends JpaRepository<Author, Long> {

    @Query("SELECT a FROM Author a JOIN FETCH a.books")
    List<Author> findAll();

    List<Author> findByName(String name);

    // Custom query
    @Query("SELECT a FROM Author a WHERE a.birthDate > :date")
    List<Author> findByBirthDateAfter(@Param("date") LocalDate date);

}
