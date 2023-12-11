package com.mkyong;

import com.mkyong.model.Author;
import com.mkyong.model.Book;
import com.mkyong.repository.AuthorRepository;
import com.mkyong.repository.BookRepository;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.autoconfigure.condition.ConditionalOnProperty;
import org.springframework.context.annotation.Bean;

import java.math.BigDecimal;
import java.time.LocalDate;
import java.util.List;

@SpringBootApplication
public class MainApplication {

    private static final Logger log = LoggerFactory.getLogger(MainApplication.class);

    public static void main(String[] args) {
        SpringApplication.run(MainApplication.class, args);
    }

    @Autowired
    BookRepository bookRepository;

    @Autowired
    AuthorRepository authorRepository;

    // Run this if app.db.init.enabled = true
    @Bean
    @ConditionalOnProperty(prefix = "app", name = "db.init.enabled", havingValue = "true")
    public CommandLineRunner demoCommandLineRunner() {
        return args -> {

            System.out.println("Running.....");

            Book b1 = new Book("Book A",
                    BigDecimal.valueOf(9.99),
                    LocalDate.of(2023, 8, 31));
            Book b2 = new Book("Book B",
                    BigDecimal.valueOf(19.99),
                    LocalDate.of(2023, 7, 31));
            Book b3 = new Book("Book C",
                    BigDecimal.valueOf(29.99),
                    LocalDate.of(2023, 6, 10));
            Book b4 = new Book("Book D",
                    BigDecimal.valueOf(39.99),
                    LocalDate.of(2023, 5, 5));
            Book b5 = new Book("Book E",
                    BigDecimal.valueOf(49.99),
                    LocalDate.of(2023, 6, 6));
            Book b6 = new Book("Book F",
                    BigDecimal.valueOf(69.99),
                    LocalDate.of(2023, 8, 8));

            // bookRepository.saveAll(List.of(b1, b2, b3, b4));

            Author a1 = new Author("Author 1", LocalDate.of(1987, 1, 2));
            Author a2 = new Author("Author 2", LocalDate.of(1988, 2, 4));
            Author a3 = new Author("Author 3", LocalDate.of(1989, 4, 4));
            Author a4 = new Author("Author 4", LocalDate.of(1990, 4, 5));
            a1.addBook(b2);
            a1.addBook(b4);
            a2.addBook(b3);
            a2.addBook(b1);
            a3.addBook(b2);
            a3.addBook(b5);
            a3.addBook(b6);
            a4.addBook(b6);
            a2.addBook(b5);
            a1.addBook(b6);
            authorRepository.saveAll(List.of(a1, a2, a3, a4));
        };
    }

}