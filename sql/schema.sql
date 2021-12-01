CREATE DATABASE IF NOT EXISTS hibernate_tutorial_crud;
USE hibernate_tutorial_crud;

CREATE TABLE movie (
    id BIGINT PRIMARY KEY AUTO_INCREMENT NOT NULL,
    title VARCHAR(45) NOT NULL,
    release_year INT NOT NULL
);
