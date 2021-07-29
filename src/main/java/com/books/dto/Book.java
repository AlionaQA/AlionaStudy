package com.books.dto;

public class Book {
    private int id;
    private String name;
    private String author;
    private Float rating;
    private Integer price;

    public Book() {
    }

    public Book(int id, String name, String author, Float rating, Integer price) {
        this.id = id;
        this.name = name;
        this.author = author;
        this.rating = rating;
        this.price = price;
    }

    public void update(Book book) {
        this.author = book.getAuthor();
        this.name = book.getName();
        this.rating = book.getRating();
        this.price = book.getPrice();
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getAuthor() {
        return author;
    }

    public void setAuthor(String author) {
        this.author = author;
    }

    public Float getRating() {
        return rating;
    }

    public void setRating(Float rating) {
        this.rating = rating;
    }

    public Integer getPrice() {
        return price;
    }

    public void setPrice(Integer price) {
        this.price = price;
    }
}
