package controller;

import entity.Book;
import repository.BookRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping
public class BookController {

    @Autowired
    private BookRepository bookRepository;

    @GetMapping("/getAllBooks")
    public ResponseEntity<List<Book>> getAllBooks(){

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

    @GetMapping("/getBookById/{id}")
    public ResponseEntity<Book> getBookById(@PathVariable Long id){

        try{
            Optional<Book>bookData= bookRepository.findById(id);

            if (bookData.isPresent()){
                return  new ResponseEntity<>(bookData.get(), HttpStatus.OK);
            }
            return new ResponseEntity<>(HttpStatus.NOT_FOUND);

        }catch (Exception ex){
            return  new ResponseEntity<>(HttpStatus.INTERNAL_SERVER_ERROR);
        }

    }

    @PostMapping("/addBook")
    public ResponseEntity<Book> addBook(@RequestBody Book book ){

        try {
            Book bookObj= bookRepository.save(book);

            return new ResponseEntity<>(bookObj,HttpStatus.OK);


        }catch (Exception ex){
            return  new ResponseEntity<>(HttpStatus.INTERNAL_SERVER_ERROR);
        }

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
