package com.example.CRUDTestApp.service.iface;

import com.example.CRUDTestApp.entity.Book;
import org.springframework.http.ResponseEntity;

import java.util.List;

public interface StudentService {

    ResponseEntity<List<Book>> getAllBooks();

    ResponseEntity<Book> getBookById(Long id);


    public ResponseEntity<Book> addBook(Book book);

}