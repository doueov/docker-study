CREATE DATABASE forum_crud_db CHARACTER SET utf8mb4 COLLATE utf8mb4_0900_ai_ci;

USE forum_crud_db;

CREATE TABLE users (
    id INT AUTO_INCREMENT PRIMARY KEY,
    username VARCHAR(50) NOT NULL,
    email VARCHAR(100) NOT NULL
);

INSERT INTO users (username, email) VALUES ('user1', 'user1@example.com');
INSERT INTO users (username, email) VALUES ('user2', 'user2@example.com');
INSERT INTO users (username, email) VALUES ('user3', 'user3@example.com');