package org.example.data.controller;

import org.example.data.model.BookClass;
import org.example.data.service.BookService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/books")
public class BookController {
    @Autowired
    private BookService bookService;

    @GetMapping
    public List<BookClass> getAllBooks() {
        return bookService.getAllBooks();
    }

    @GetMapping("/{id}")
    public BookClass getBookById(@PathVariable String id) {
        return bookService.getBookById(id);
    }

    @PostMapping
    public BookClass createBook(@RequestBody BookClass book) {
        return bookService.saveBook(book);
    }

    @PutMapping("/{id}")
    public BookClass updateBook(@PathVariable String id, @RequestBody BookClass book) {
        book.setId(id);
        return bookService.saveBook(book);
    }

    @DeleteMapping("/{id}")
    public void deleteBook(@PathVariable String id) {
        bookService.deleteBook(id);
    }
}
