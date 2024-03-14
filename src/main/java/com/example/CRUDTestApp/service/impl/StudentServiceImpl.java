package com.example.CRUDTestApp.service.impl;

import com.example.CRUDTestApp.entity.Book;
import com.example.CRUDTestApp.repository.BookRepository;
import com.example.CRUDTestApp.service.iface.StudentService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

@Service
public class StudentServiceImpl implements StudentService {

    @Autowired
    private BookRepository bookRepository;

    @Override
    public ResponseEntity<List<Book>> getAllBooks() {
        try {
            List<Book> bookList = new ArrayList<>();
            bookRepository.findAll().forEach(bookList::add);

            if (bookList.isEmpty()){
                return new ResponseEntity<>(HttpStatus.NO_CONTENT);
            }
            return  new ResponseEntity<>(bookList, HttpStatus.OK);

        }catch (Exception ex){
            return  new ResponseEntity<>(HttpStatus.INTERNAL_SERVER_ERROR);
        }
    }

    @Override
    public ResponseEntity<Book> getBookById(Long id) {
        try{
            Optional<Book> bookData= bookRepository.findById(id);

            if (bookData.isPresent()){
                return  new ResponseEntity<>(bookData.get(), HttpStatus.OK);
            }
            return new ResponseEntity<>(HttpStatus.NOT_FOUND);

        }catch (Exception ex){
            return  new ResponseEntity<>(HttpStatus.INTERNAL_SERVER_ERROR);
        }
    }

    @Override
    public ResponseEntity<Book> addBook(Book book) {
        try {
            Book bookObj= bookRepository.save(book);

            return new ResponseEntity<>(bookObj,HttpStatus.OK);


        }catch (Exception ex){
            return  new ResponseEntity<>(HttpStatus.INTERNAL_SERVER_ERROR);
        }
    }


}
