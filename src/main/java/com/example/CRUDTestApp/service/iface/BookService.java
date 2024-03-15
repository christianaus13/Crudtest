package com.example.CRUDTestApp.service.iface;

import com.example.CRUDTestApp.entity.Book;
import org.springframework.http.ResponseEntity;

import java.util.List;

public interface BookService {

    ResponseEntity<List<Book>> getAllBooks();

    ResponseEntity<Book> getBookById(Long id);


    ResponseEntity<Book> addBook(Book book);

}
