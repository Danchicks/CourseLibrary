package org.example.kapusta;

import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class BookController {

    private final BookRepository bookRepository;

    public BookController(BookRepository bookRepository) {
        this.bookRepository = bookRepository;
    }

    @DeleteMapping("/books/{id}")
    public ResponseEntity<String> removeBook(@PathVariable String id) {
        bookRepository.deleteById(id);
        return ResponseEntity.ok("Book successfully deleted");
    }
}
