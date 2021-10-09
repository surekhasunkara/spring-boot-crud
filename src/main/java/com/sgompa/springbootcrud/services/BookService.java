package com.sgompa.springbootcrud.services;

import com.sgompa.springbootcrud.entities.Book;
import com.sgompa.springbootcrud.repos.BookRepo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class BookService implements IBookService {
    @Autowired
    BookRepo bookRepo;

    @Override
    public Book createBook(Book book) {
        return bookRepo.save(book);
    }

    @Override
    public void updateBook(Book book) {
        bookRepo.save(book);
    }

    @Override
    public void deleteBook(int bookId) {
        Book b = bookRepo.getById(bookId);
        bookRepo.delete(b);
    }

    @Override
    public Book getBookById(int bookId) {
        return bookRepo.findBookById(bookId);
    }

    @Override
    public List<Book> getAllBooks() {
        return bookRepo.findAll();
    }
}
