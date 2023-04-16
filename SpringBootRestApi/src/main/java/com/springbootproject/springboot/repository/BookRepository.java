package com.springbootproject.springboot.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.springbootproject.springboot.entity.Book;

public interface BookRepository extends JpaRepository<Book,Integer> {
    public Book findById(int id);
    
}
