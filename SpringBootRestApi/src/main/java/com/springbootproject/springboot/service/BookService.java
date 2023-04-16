package com.springbootproject.springboot.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import com.springbootproject.springboot.entity.Book;
import com.springbootproject.springboot.repository.BookRepository;

@Service
public class BookService {

    @Autowired
    private BookRepository bookRepository;
    // private static List<Book> list = new ArrayList<>();

    // static{
    //     list.add(new Book(2,"java","mani"));
    //     list.add(new Book(5,"sql","akshay"));
    //     list.add(new Book(23,"spring","shweta"));
    // }
    // get All Books
    public List<Book> getAllBook(){
        List<Book> list =bookRepository.findAll();
        return list;
    }
    // get single book by id
    public Book getBookById(int id) {
        Book book = null;

        try{
    //    book = list.stream().filter(e->e.getId()==id).findFirst().get();
            bookRepository.findById(id);
        }catch(Exception e){
            e.printStackTrace();
        }
        return book;
         
    }
//   save book
    public Book saveBook(Book book) {

        bookRepository.save(book);
        return book;

    }
    // delete book
    public void deleteBook(int bookId) {
    //    list= list.stream().filter(e->{
    //         if(e.getId()!=bookId){
    //             return true;
    //         }
    //         else{
    //             return false;
    //         }
    //     }).collect(Collectors.toList());

    bookRepository.deleteById(bookId);

    }
    // update book
    public void updateBook(Book book, int bookId) {
    //    list = list.stream().map(b->{
    //     if(b.getId()==bookId){
    //         b.setTitle(book.getTitle());
    //         b.setAuthor(book.getAuthor());
    //     }
    //     return b;

    //    } ).collect(Collectors.toList());
    book.setId(bookId);
    bookRepository.save(book);
       
    }
    
    
  

}
