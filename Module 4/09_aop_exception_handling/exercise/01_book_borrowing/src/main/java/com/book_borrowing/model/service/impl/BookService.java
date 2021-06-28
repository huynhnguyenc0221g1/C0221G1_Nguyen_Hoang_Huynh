package com.book_borrowing.model.service.impl;

import com.book_borrowing.model.entity.Book;
import com.book_borrowing.model.entity.BorrowCode;
import com.book_borrowing.model.repository.IBookRepository;
import com.book_borrowing.model.service.IBookService;
import org.springframework.beans.factory.annotation.Autowired;

import java.util.List;

public class BookService implements IBookService {
    @Autowired
    IBookRepository bookRepository;

    @Override
    public List<Book> findAll() {
        return bookRepository.findAll();
    }

    @Override
    public void createBook(Book book) {
        bookRepository.save(book);
    }

    @Override
    public Book findById(Integer id) {
        return bookRepository.findById(id).orElse(null);
    }

    @Override
    public void updateBook(Book book) {
        bookRepository.save(book);
    }

    @Override
    public void lendBook(BorrowCode borrowCode) {

    }
}
