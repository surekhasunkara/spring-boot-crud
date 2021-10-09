package com.sgompa.springbootcrud.services;

import com.sgompa.springbootcrud.entities.Book;

import java.util.List;

public interface IBookService {

    Book createBook(Book book);
    void updateBook(Book book);
    void deleteBook(int bookId);
    Book getBookById(int bookId);
    List<Book> getAllBooks();
}
