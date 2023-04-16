package com.springbootproject.springboot.controller;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import com.springbootproject.springboot.entity.Book;
import com.springbootproject.springboot.service.BookService;

@RestController
public class BookController {

    @Autowired
    private BookService service;
    // get/read/fetch handler
    // @GetMapping("/")
    // public List<Book> getAllBook(){
    //     return this.service.getAllBook();
    // }

    // @Response Entity and Exception handling
    @GetMapping("/")
    public ResponseEntity<List<Book>> getAllBook(){
        List<Book> list = this.service.getAllBook();
        if(list.size()<=0){
            return ResponseEntity.status(HttpStatus.NOT_FOUND).build();
        }
       
        return ResponseEntity.of(Optional.of(list));
    }

// get by id handler
    @GetMapping("/{id}")
    public ResponseEntity<Book> getBook(@PathVariable("id") int id){

        Book book = service.getBookById(id);
        if(book==null){
            return ResponseEntity.status(HttpStatus.NO_CONTENT).build();
        }
        return ResponseEntity.of(Optional.of(book));
    }

// save/new handler
    @PostMapping("/")
    public ResponseEntity<Book> saveBook(@RequestBody Book book){
           Book b = null;
           try{
            b = service.saveBook(book);
            System.out.println(book);
            return ResponseEntity.of(Optional.of(b));
           }catch(Exception e){
              e.printStackTrace();
              return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).build();
             
           }         
        
    }

    // Delete handler
    @DeleteMapping("/{id}")
    public ResponseEntity<Object> deleteBook(@PathVariable("id") int bookId){
        try{
            service.deleteBook(bookId);
            return ResponseEntity.status(HttpStatus.IM_USED).build();
        }catch(Exception e){
          e.printStackTrace();
          return ResponseEntity.status(HttpStatus.BAD_GATEWAY).build();
        }
       

        
    }

    // update handler
    @PutMapping("/{id}")
    public ResponseEntity<Book> updateBook(@PathVariable("id") int bookId, @RequestBody Book book){
        try{
            service.updateBook(book,bookId);
            return ResponseEntity.ok().body(book);
        }catch(Exception e){
            e.printStackTrace();
            return ResponseEntity.status(HttpStatus.BAD_REQUEST).build();
        }

    }
}
