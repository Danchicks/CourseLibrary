package org.example.data.controller;

import org.example.data.model.BookClass;
import org.springframework.web.bind.annotation.*;

import java.util.Collection;
import java.util.Map;
import java.util.concurrent.ConcurrentHashMap;

@RestController
@RequestMapping("/books")
public class BookController {

    private Map<String, BookClass> bookRepository = new ConcurrentHashMap<>();

    @GetMapping
    public Collection<BookClass> getAllBooks() {
        return bookRepository.values();
    }

    @PostMapping
    public BookClass addBook(@RequestBody BookClass book) {
        bookRepository.put(book.getId(), book);
        return book;
    }

    @PutMapping("/{id}")
    public BookClass updateBook(@PathVariable String id, @RequestBody BookClass book) {
        bookRepository.put(id, book);
        return book;
    }

    @GetMapping("/{id}")
    public BookClass getBook(@PathVariable String id) {
        return bookRepository.get(id);
    }

    @DeleteMapping("/{id}")
    public void deleteBook(@PathVariable String id) {
        bookRepository.remove(id);
    }
}
