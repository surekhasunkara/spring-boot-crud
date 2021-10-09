package com.sgompa.springbootcrud.controllers;

import com.sgompa.springbootcrud.entities.Book;
import com.sgompa.springbootcrud.services.BookService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("api/books")
public class BookController {
    @Autowired
    BookService bookService;

    @PostMapping(value = "/")
    public Book createBook(@RequestBody Book book){
        return bookService.createBook(book);
    }
    @PutMapping(value = "/")
    public void updateBook(@RequestBody Book book){
        bookService.updateBook(book);
    }
    @DeleteMapping(value="/{bookId}")
    public void deleteBook(@PathVariable int bookId){
        bookService.deleteBook(bookId);
    }
    @GetMapping(value = "/", produces = "application/json")
    public List<Book> getAllBooks(){
        return bookService.getAllBooks();
    }
    @GetMapping(value = "/{bookId}", produces = "application/json")
    public Book getBookById(@PathVariable int bookId){
        return bookService.getBookById(bookId);
    }
}
