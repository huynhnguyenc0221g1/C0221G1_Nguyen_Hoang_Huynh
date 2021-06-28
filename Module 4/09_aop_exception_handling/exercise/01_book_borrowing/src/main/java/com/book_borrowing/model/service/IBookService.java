package com.book_borrowing.model.service;

import com.book_borrowing.model.entity.Book;
import com.book_borrowing.model.entity.BorrowCode;

import java.util.List;

public interface IBookService {
    List<Book> findAll();
    void createBook(Book book);
    Book findById(Integer id);
    void updateBook(Book book);
    void giveBook(BorrowCode borrowCode);

}
