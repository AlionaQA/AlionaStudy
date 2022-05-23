CREATE SCHEMA IF NOT EXISTS books;

CREATE TABLE IF NOT EXISTS books.book
(
    id     INT PRIMARY KEY,
    name   VARCHAR(255) NOT NULL,
    author VARCHAR(255) NOT NULL,
    rating FLOAT,
    price  FLOAT        NOT NULL
);

INSERT INTO books.book (id, name, author, rating, price)
VALUES (1, 'Clean Code', 'Robert C. Martin', 3.9, 640.50),
       (2, 'The Richest Man in Babylon', 'George S. Clason', 4.8, 320.00),
       (3, 'The Power of Now', 'Eckhart Tolle', 4.2, 700.00);