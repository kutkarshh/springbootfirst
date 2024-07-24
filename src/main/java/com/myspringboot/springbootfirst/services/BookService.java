package com.myspringboot.springbootfirst.services;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.myspringboot.springbootfirst.dao.BookRepository;
import com.myspringboot.springbootfirst.entities.Book;

@Service
public class BookService {

    @Autowired
    private BookRepository bookRepository;

    // Insert Book
    public Book saveBook(Book book) {
        return bookRepository.save(book);
    }

    // Insert all Books
    public List<Book> saveBooks(List<Book> books) {
        List<Book> list = new ArrayList<>();
        bookRepository.saveAll(books).forEach(book -> list.add(book));
        return list;
    }

    // Get all Books
    public List<Book> getAllBooks() {
        List<Book> books = bookRepository.getAllBooks();
        return books;
    }

    // Get Book by Id
    public Book getBookById(int id) {
        Book book = bookRepository.findById(id).get();
        return book;
    }

    // Update Book
    public Book updateBook(Book book, int id) {
        Book updateBook = bookRepository.findById(id).get();
        updateBook.setTitle(book.getTitle());
        updateBook.setAuthor(book.getAuthor());
        return bookRepository.save(updateBook);
    }

    // Delete Book
    public void deleteBook(int id) {
        bookRepository.deleteById(id);
    }

    // Delete All the Books
    public void deleteAllBooks() {
        bookRepository.deleteAll();
    }
}
