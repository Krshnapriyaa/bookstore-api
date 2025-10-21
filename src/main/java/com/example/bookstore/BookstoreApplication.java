package com.example.bookstore;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication
public class BookstoreApplication {
    public static void main(String[] args) {
        SpringApplication.run(BookstoreApplication.class, args);
        System.out.println(" Bookstore API is running on http://localhost:8080");
        System.out.println(" Swagger UI: http://localhost:8080/swagger-ui/index.html");
    }
}
