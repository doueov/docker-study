CREATE DATABASE forum_crud_db CHARACTER SET utf8mb4 COLLATE utf8mb4_0900_ai_ci;

USE forum_crud_db;

CREATE TABLE posts (
    id INT AUTO_INCREMENT PRIMARY KEY,
    author VARCHAR(255) NOT NULL,
    title VARCHAR(255) NOT NULL,
    content TEXT NOT NULL,
    password VARCHAR(255) NOT NULL,
    createdAt DATETIME NOT NULL DEFAULT CURRENT_TIMESTAMP
);

INSERT INTO posts (author, title, content, password) VALUES("author 1", "title 1", "content 1", "1234");
INSERT INTO posts (author, title, content, password) VALUES("author 2", "title 2", "content 2", "1234");
INSERT INTO posts (author, title, content, password) VALUES("author 3", "title 3", "content 3", "2345");
INSERT INTO posts (author, title, content, password) VALUES("author 4", "title 4", "content 4", "3456");
INSERT INTO posts (author, title, content, password) VALUES("author 5", "title 5", "content 5", "4567");

-- DROP DATABASE forum_crud_db;