package com.myspringboot.springbootfirst.controllers;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import com.myspringboot.springbootfirst.entities.Book;
import com.myspringboot.springbootfirst.services.BookService;

import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;

// RestController = @Controller + @ResponseBody 
@RestController
public class BookController {

    @Autowired
    private BookService bookService;

    @RequestMapping(path = "/books", method = RequestMethod.GET)
    public List<Book> getBooks() {
        // Static Custom Book creation and return
        // Book book = new Book();
        // book.setAuthor("John Doe");
        // book.setTitle("My Book");
        // book.setId(101);

        List<Book> book = bookService.getAllBooks();

        return book;
    }

    @GetMapping("/books/{id}")
    public Book getBookById(@PathVariable("id") int id) {
        Book book = bookService.getBookById(id);
        return book;
    }

    @PutMapping("/books/{id}")
    public Book updateBookById(@RequestBody Book book, @PathVariable("id") int id) {

        Book result = bookService.updateBook(book, id);
        return result;
    }

    @PostMapping("/books")
    public Book createBook(@RequestBody Book book) {
        Book resultBook = bookService.saveBook(book);
        return resultBook;
    }

    @PostMapping("/nbooks")
    public List<Book> createNBooks(@RequestBody List<Book> books) {
        List<Book> resultBook = bookService.saveBooks(books);
        return resultBook;
    }

    @DeleteMapping("/books/{id}")
    public void deleteBookById(@PathVariable("id") int id) {
        bookService.deleteBook(id);
    }

    @DeleteMapping("/books")
    public void deleteAllBooks() {
        bookService.deleteAllBooks();
    }
}
