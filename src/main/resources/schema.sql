CREATE DATABASE IF NOT EXISTS books CHARACTER SET utf8mb4;

CREATE TABLE IF NOT EXISTS `book`
(
    id     INT AUTO_INCREMENT PRIMARY KEY,
    name   VARCHAR(255) NOT NULL,
    author VARCHAR(255) NOT NULL,
    rating FLOAT,
    price  FLOAT        NOT NULL
)
    ENGINE = INNODB;

INSERT INTO `book` (id, name, author, rating, price)
VALUES (1, 'Clean Code', 'Robert C. Martin', 3.9, 640.50),
       (2, 'The Richest Man in Babylon', 'George S. Clason', 4.8, 320.00),
       (3, 'The Power of Now', 'Eckhart Tolle', 4.2, 700.00);