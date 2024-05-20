package org.example.data.service;

import org.example.data.model.BookClass;
import org.springframework.stereotype.Service;

import java.util.Collection;
import java.util.HashMap;
import java.util.Map;

@Service
public class BookService {
    private final Map<String, BookClass> books = new HashMap<>();

    public Collection<BookClass> getAllBooks() {
        return books.values();
    }

    public void addBook(BookClass book) {
        books.put(book.getId(), book);
    }

    public void updateBook(String id, BookClass book) {
        books.put(id, book);
    }

    public void deleteBook(String id) {
        books.remove(id);
    }
}
