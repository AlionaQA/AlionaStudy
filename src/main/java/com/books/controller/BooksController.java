package com.books.controller;

import com.books.dto.Book;
import com.books.exceptions.BadRequestException;
import com.books.exceptions.NotFoundException;
import org.springframework.web.bind.annotation.*;

import java.util.ArrayList;
import java.util.List;

import static org.apache.logging.log4j.util.Strings.isBlank;

@RestController
@RequestMapping("books")
public class BooksController {

    private int increment = 4;

    private final List<Book> books = new ArrayList<>() {{
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
        validateBook(newBook);
        newBook.setId(increment++);
        books.add(newBook);
        return newBook;
    }

    @PutMapping("{id}")
    public Book update(@PathVariable int id, @RequestBody Book bookForUpdate) {
        validateBook(bookForUpdate);
        Book existedBook = getBookById(id);
        existedBook.update(bookForUpdate);
        return existedBook;
    }

    private void validateBook(Book book) {
        if (isBlank(book.getName()) || isBlank(book.getAuthor()) || book.getPrice() == null) {
            throw new BadRequestException();
        }
    }

    private Book getBookById(int id) {
        return books.stream().filter(book -> book.getId() == id).findFirst().orElseThrow(NotFoundException::new);
    }

}
