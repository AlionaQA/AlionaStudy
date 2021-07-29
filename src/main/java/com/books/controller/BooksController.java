package com.books.controller;

import com.books.dto.Book;
import com.books.exceptions.NotFoundException;
import org.springframework.security.access.annotation.Secured;
import org.springframework.web.bind.annotation.*;

import java.util.ArrayList;
import java.util.List;

import static com.books.validator.BookValidator.validate;
import static java.util.stream.Collectors.toList;

@RestController
@RequestMapping("books")
public class BooksController {

    private int increment = 4;

    private List<Book> books = new ArrayList<>() {{
        add(new Book(1, "Чистий код", "Роберт Мартін", 4.4f, 350));
        add(new Book(2, "Найбагатший чоловік у Вавилоні", "Джордж Клейсон", 4.8f, 220));
        add(new Book(3, "Сила моменту тепер", "Екгарт Толле", 4.2f, 530));
    }};

    @GetMapping
    public List<Book> getBooks() {
        return books;
    }

    @GetMapping("{id}")
    public Book getBook(@PathVariable int id) {
        return getBookById(id);
    }

    @PostMapping
    public Book create(@RequestBody Book newBook) {
        validate(newBook);
        newBook.setId(increment++);
        books.add(newBook);
        return newBook;
    }

    @PutMapping("{id}")
    public Book update(@PathVariable int id, @RequestBody Book book) {
        validate(book);
        Book existingBook = getBookById(id);
        existingBook.update(book);
        return existingBook;
    }

    @Secured("ROLE_ADMIN")
    @DeleteMapping("{id}")
    public void delete(@PathVariable int id) {
        Book existingBook = getBookById(id);
        remove(existingBook.getId());
    }

    private Book getBookById(int id) {
        return books.stream().filter(book -> book.getId() == id).findFirst().orElseThrow(NotFoundException::new);
    }

    private void remove(Integer idRoRemove) {
        books = books.stream().filter(book -> book.getId() != idRoRemove).collect(toList());
    }

}
