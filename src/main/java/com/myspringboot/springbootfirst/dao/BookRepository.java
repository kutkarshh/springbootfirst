package com.myspringboot.springbootfirst.dao;

import java.util.List;

import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;

import com.myspringboot.springbootfirst.entities.Book;

public interface BookRepository extends CrudRepository<Book, Integer> {
    // Fetch Books by title
    public List<Book> findByTitle(String title);

    // Fetch Books by author
    // public List<Book> findByAuthor(String author);

    // Fetch all Books
    @Query("select b from Book b")
    public List<Book> getAllBooks();
}
