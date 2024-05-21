package org.example.data.service;

import org.example.data.model.BookClass;
import org.example.data.repository.BookRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class BookService {
    @Autowired
    private BookRepository bookRepository;

    public List<BookClass> getAllBooks() {
        return bookRepository.findAll();
    }

    public BookClass getBookById(String id) {
        return bookRepository.findById(id).orElse(null);
    }

    public BookClass saveBook(BookClass book) {
        return bookRepository.save(book);
    }

    public void deleteBook(String id) {
        bookRepository.deleteById(id);
    }
}
