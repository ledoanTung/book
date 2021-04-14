package com.example.demo.controller;

import com.example.demo.model.Book;
import com.example.demo.service.book.IBookService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@Controller
@RequestMapping("/books")
@CrossOrigin("*")
public class BookController {
    @Autowired
    IBookService bookService;

    @GetMapping("")
    public ResponseEntity<List<Book>> list(){
        List<Book> books =bookService.findAll();
        return new ResponseEntity<>(books, HttpStatus.OK);
    }
    @PostMapping("create")
    public ResponseEntity<List<Book>>create(@RequestBody Book book){
        bookService.save(book);
        return new ResponseEntity<>(HttpStatus.CREATED);
    }
    @GetMapping("/{id}")
    public ResponseEntity<Book>findBookById(@PathVariable Long id){
        Book book = bookService.findById(id);
        return new ResponseEntity<>(book,HttpStatus.OK);
    }
    @PutMapping("/edit/{id}")
    public ResponseEntity<Book> edit(@RequestBody Book book , @PathVariable Long id){
        book.setId(id);
        bookService.save(book);
        return new ResponseEntity<>(book, HttpStatus.OK);
    }
    @DeleteMapping("/delete/{id}")
    public ResponseEntity<Book> delete(@PathVariable Long id){
        Book book = bookService.findById(id);
        bookService.delete(id);
        return new ResponseEntity<>(HttpStatus.NO_CONTENT);
    }
}
