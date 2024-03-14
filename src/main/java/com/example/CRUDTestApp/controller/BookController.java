package com.example.CRUDTestApp.controller;


/**
 *
 * ang pogi ko shet
 *
 *
 * **/



import com.example.CRUDTestApp.entity.Book;
import com.example.CRUDTestApp.repository.BookRepository;
import com.example.CRUDTestApp.service.iface.StudentService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping
public class BookController {

    @Autowired
    private BookRepository bookRepository;
    @Autowired
    private StudentService studentService;

    @GetMapping("/getAllBooks")
    public ResponseEntity<List<Book>> getAllBooks(){
        return studentService.getAllBooks();
    }

    @GetMapping("/getBookById/{id}")
    public ResponseEntity<Book> getBookById(@PathVariable Long id){
        return studentService.getBookById(id);
    }

    @PostMapping("/addBook")
    public ResponseEntity<Book> addBook(@RequestBody Book book ){
        return studentService.addBook(book);
    }

    @PostMapping("/updateBookById/(id)")
    public ResponseEntity<Book> updateBookById(@PathVariable Long id, @RequestBody Book newBookData){
        Optional<Book>oldBookData= bookRepository.findById(id);

        if (oldBookData.isPresent()){
            Book updatedBookdata=oldBookData.get();

            updatedBookdata.setTitle(newBookData.getTitle());
            updatedBookdata.setAuthor(newBookData.getAuthor());
            updatedBookdata.setCategory(newBookData.getCategory());

            Book bookObj= bookRepository.save(updatedBookdata);

            return new ResponseEntity<>(bookObj,HttpStatus.OK);
        }
        return new ResponseEntity<>(HttpStatus.NO_CONTENT);
    }

    @DeleteMapping("/deleteBookById/(id)")
    public ResponseEntity<HttpStatus> deleteBookById(@PathVariable Long id){

        bookRepository.deleteById(id);

        return new ResponseEntity<>(HttpStatus.OK);
    }



}
