package com.books;

import com.books.model.Book;
import com.books.repo.BookRepository;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;

@SpringBootApplication
public class BooksApplication {

    public static void main(String[] args) {
        SpringApplication.run(BooksApplication.class, args);
    }

    @Bean
    CommandLineRunner commandLineRunner(BookRepository bookRepository) {
        return args -> {
            bookRepository.save(new Book("Clean Code", "Robert C. Martin", 3.9f, 640));
            bookRepository.save(new Book("The Richest Man in Babylon", "George S. Clason", 4.8f, 320));
            bookRepository.save(new Book("The Power of Now", "Eckhart Tolle", 4.2f, 700));
        };
    }

}
