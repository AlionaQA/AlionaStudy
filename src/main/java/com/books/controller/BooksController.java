package com.books.controller;

import com.books.exceptions.NotFoundException;
import com.books.model.Book;
import com.books.repo.BookRepository;
import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.access.annotation.Secured;
import org.springframework.web.bind.annotation.*;

import java.util.List;

import static com.books.validator.BookValidator.validate;

@RestController
@RequestMapping("books")
public class BooksController {

    private final BookRepository bookRepository;

    @Autowired
    public BooksController(BookRepository bookRepository) {
        this.bookRepository = bookRepository;
    }

    @GetMapping
    public List<Book> getBooks() {
        return bookRepository.findAll();
    }

    @GetMapping("{id}")
    public Book getBook(@PathVariable Long id) {
        return bookRepository.findById(id).orElseThrow(NotFoundException::new);
    }

    @PostMapping
    public Book create(@RequestBody Book book) {
        validate(book);
        return bookRepository.save(book);
    }

    @PutMapping("{id}")
    public Book update(@PathVariable Long id, @RequestBody Book book) {
        Book bookFromDB = bookRepository.findById(id).orElseThrow(NotFoundException::new);
        BeanUtils.copyProperties(book, bookFromDB, "id");
        return bookRepository.save(bookFromDB);
    }

    @Secured("ROLE_ADMIN")
    @DeleteMapping("{id}")
    public void delete(@PathVariable Long id) {
        Book bookToDelete = bookRepository.findById(id).orElseThrow(NotFoundException::new);
        bookRepository.deleteById(bookToDelete.getId());
    }
}
