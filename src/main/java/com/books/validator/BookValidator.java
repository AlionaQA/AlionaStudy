package com.books.validator;

import com.books.dto.Book;
import org.apache.logging.log4j.util.Strings;
import org.springframework.http.HttpStatus;
import org.springframework.web.server.ResponseStatusException;

public class BookValidator {

    public static void validate(Book book) {
        validateBookName(book.getName());
        validateBookAuthor(book.getAuthor());
        validateBookRating(book.getRating());
        validateBookPrice(book.getPrice());
    }

    private static void validateBookName(String name) {
        if (Strings.isBlank(name)) {
            throw new ResponseStatusException(HttpStatus.BAD_REQUEST, "Name is required");
        }
        if (name.length() > 50) {
            throw new ResponseStatusException(HttpStatus.BAD_REQUEST, "Max name length is 50 chars");
        }
        validateNameOnDigits(name);
    }

    private static void validateNameOnDigits(String name) {
        char[] chars = name.toCharArray();
        for (char c : chars) {
            if (Character.isDigit(c)) {
                throw new NullPointerException();
            }
        }
    }

    private static void validateBookAuthor(String author) {
        if (Strings.isBlank(author)) {
            throw new ResponseStatusException(HttpStatus.BAD_REQUEST, "Author is required");
        }
        if (author.length() > 30) {
            throw new ResponseStatusException(HttpStatus.BAD_REQUEST, "Max author length is 30 chars");
        }
    }

    private static void validateBookRating(Float rating) {
        if (rating == null || rating == 0.0f) {
            return;
        }
        if (rating > 5.0f || rating < 0.0f) {
            throw new ResponseStatusException(HttpStatus.BAD_REQUEST, "Rating must be between 0.0 and 5.0");
        }
    }

    private static void validateBookPrice(Integer price) {
        if (price == null || price == 0) {
            throw new ResponseStatusException(HttpStatus.BAD_REQUEST, "Price is required");
        }
        if (price <= 0 || price > 250000) {
            throw new ResponseStatusException(HttpStatus.BAD_REQUEST, "Price must be more than 0 and less than 250000");
        }
    }
}
