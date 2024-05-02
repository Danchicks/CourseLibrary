package org.example.kapusta;

import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
public class BookController {

    private final BookRepository bookRepository;

    public BookController(BookRepository bookRepository) {
        this.bookRepository = bookRepository;
    }

    @DeleteMapping("/books/{id}")
    public ResponseEntity<String> removeBook(@PathVariable String id) {
        Book book = bookRepository.findById(id).orElse(null);
        if (book == null) {
            return ResponseEntity.notFound().build();
        }
        if(book.getQuantity() == 1){
            bookRepository.deleteById(id);
            return ResponseEntity.ok("Book successfully deleted");
        }
        book.setQuantity(book.getQuantity() - 1);
        bookRepository.save(book);
        return ResponseEntity.ok("Book quantity incremented");
    }

    @PostMapping("/books/{id}")
    public ResponseEntity<String> addOneBook(@PathVariable String id) {
        Book book = bookRepository.findById(id).orElse(null);
        if (book == null) {
            return ResponseEntity.notFound().build();
        }
        book.setQuantity(book.getQuantity() + 1);
        bookRepository.save(book);
        return ResponseEntity.ok("Book quantity incremented");
    }
}
