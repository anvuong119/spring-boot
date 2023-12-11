package com.mkyong.service;

import com.mkyong.model.Author;
import com.mkyong.model.Book;
import com.mkyong.repository.AuthorRepository;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.time.LocalDate;
import java.util.List;
import java.util.Optional;

@Service
public class AuthorService {

    @Autowired
    private AuthorRepository authorRepository;

    @Autowired
    private BookService bookService;

    public List<Author> findAll() {
        return authorRepository.findAll();
    }

    public Optional<Author> findById(Long id) {
        return authorRepository.findById(id);
    }

    public Author save(Author author) {
        return authorRepository.save(author);
    }

    public void deleteById(Long id) {
        authorRepository.deleteById(id);
    }

    public void removeBook(Long authorId, Long bookId) {
        Optional<Author> authorOptional = findById(authorId);
        Optional<Book> bookOptional = bookService.findById(bookId);
        if (authorOptional.isPresent() && bookOptional.isPresent()) {
            Author author = authorOptional.get();
            Book book = bookOptional.get();
            author.removeBook(book);
            authorRepository.save(author);
        }
    }

    public List<Author> findByName(String name) {
        return authorRepository.findByName(name);
    }

    public List<Author> findByBirthDateAfter(LocalDate date) {
        return authorRepository.findByBirthDateAfter(date);
    }
}
