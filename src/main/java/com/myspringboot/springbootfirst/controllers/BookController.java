package com.myspringboot.springbootfirst.controllers;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
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
    public ResponseEntity<List<Book>> getBooks() {
        // Static Custom Book creation and return
        // Book book = new Book();
        // book.setAuthor("John Doe");
        // book.setTitle("My Book");
        // book.setId(101);

        List<Book> books = bookService.getAllBooks();

        if (books.size() <= 0) {
            return ResponseEntity.status(HttpStatus.NOT_FOUND).build();
        }

        return ResponseEntity.of(Optional.of(books));
    }

    @GetMapping("/books/{id}")
    public ResponseEntity<Book> getBookById(@PathVariable("id") int id) {
        Book book = bookService.getBookById(id);

        if (book == null || book.getId() <= 0) {
            return ResponseEntity.status(HttpStatus.NOT_FOUND).build();
        }

        return ResponseEntity.status(HttpStatus.ACCEPTED).body(book);
    }

    @PutMapping("/books/{id}")
    public ResponseEntity<Book> updateBookById(@RequestBody Book book, @PathVariable("id") int id) {

        Book result = null;
        result = bookService.updateBook(book, id);
        if (result != null)
            return ResponseEntity.ok().body(result);
        else
            return ResponseEntity.status(HttpStatus.NOT_FOUND).build();
    }

    @PostMapping("/books")
    public ResponseEntity<Book> createBook(@RequestBody Book book) {
        Book resultBook = null;
        try {
            resultBook = bookService.saveBook(book);
            return ResponseEntity.status(HttpStatus.CREATED).body(resultBook);
        } catch (Exception e) {
            e.printStackTrace();
            return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).build();
        }
    }

    @PostMapping("/nbooks")
    public ResponseEntity<List<Book>> createNBooks(@RequestBody List<Book> books) {
        List<Book> resultBook = null;
        try {
            resultBook = bookService.saveBooks(books);
            return ResponseEntity.status(HttpStatus.CREATED).body(resultBook);
        } catch (Exception e) {
            e.printStackTrace();
            return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).build();
        }
    }

    @DeleteMapping("/books/{id}")
    public ResponseEntity<String> deleteBookById(@PathVariable("id") int id) {
        try {
            if (bookService.getBookById(id) == null) {
                return ResponseEntity.status(HttpStatus.NOT_FOUND).build();
            }
            bookService.deleteBook(id);
            return ResponseEntity.status(HttpStatus.CREATED).body("Book Deleted!");
        } catch (Exception e) {
            e.printStackTrace();
            return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).build();
        }
    }

    @DeleteMapping("/books")
    public ResponseEntity<String> deleteAllBooks() {
        try {
            if (bookService.getAllBooks().size() <= 0) {
                return ResponseEntity.status(HttpStatus.NOT_FOUND).build();
            }
            bookService.deleteAllBooks();
            return ResponseEntity.status(HttpStatus.NO_CONTENT).body("All Books Deleted!");
        } catch (Exception e) {
            e.printStackTrace();
            return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).build();
        }
    }
}
