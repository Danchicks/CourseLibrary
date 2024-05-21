package org.example.data.repository;

import org.example.data.model.BookClass;
import org.springframework.data.mongodb.repository.MongoRepository;

public interface BookRepository extends MongoRepository<BookClass, String> {
}
