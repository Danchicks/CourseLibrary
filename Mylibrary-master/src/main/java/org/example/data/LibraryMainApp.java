package org.example.data;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.data.mongodb.repository.config.EnableMongoRepositories;

@SpringBootApplication
@EnableMongoRepositories
public class LibraryMainApp {
    public static void main(String[] args) {
        SpringApplication.run(LibraryMainApp.class, args);
    }
}
