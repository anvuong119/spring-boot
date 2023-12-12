package com.mkyong.controller;

import com.mkyong.model.Author;
import com.mkyong.service.AuthorService;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.format.annotation.DateTimeFormat;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;

import java.time.LocalDate;
import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("/authors")
public class AuthorController {

    @Autowired
    private AuthorService authorService;

    @GetMapping
    public List<Author> findAll() {
        return authorService.findAll();
    }

    @GetMapping("/{id}")
    public Optional<Author> findById(@PathVariable Long id) {
        return authorService.findById(id);
    }

    // create an author
    @ResponseStatus(HttpStatus.CREATED) // 201
    @PostMapping
    public Author create(@RequestBody Author author) {
        return authorService.save(author);
    }

    // update a book
    @PutMapping
    public Author update(@RequestBody Author author) {
        return authorService.save(author);
    }

    // remove a book from an author
    @ResponseStatus(HttpStatus.NO_CONTENT)
    @PutMapping("/{id}/remove/book/{bookId}")
    public void removeBookFromAuthor(@PathVariable Long id, @PathVariable Long bookId) {
        authorService.removeBook(id, bookId);
    }

    // remove a car from an author
    @ResponseStatus(HttpStatus.NO_CONTENT)
    @PutMapping("/{id}/remove/car/{carId}")
    public void removeCarFromAuthor(@PathVariable Long id, @PathVariable Long carId) {
        authorService.removeCar(id, carId);
    }

    // delete an author
    @ResponseStatus(HttpStatus.NO_CONTENT) // 204
    @DeleteMapping("/{id}")
    public void deleteById(@PathVariable Long id) {
        authorService.deleteById(id);
    }

    @GetMapping("/find/name/{name}")
    public List<Author> findByAuthor(@PathVariable String name) {
        return authorService.findByName(name);
    }

    @GetMapping("/find/birthdate-after/{date}")
    public List<Author> findByBirthDateAfter(
            @PathVariable @DateTimeFormat(pattern = "yyyy-MM-dd") LocalDate date) {
        return authorService.findByBirthDateAfter(date);
    }

}
