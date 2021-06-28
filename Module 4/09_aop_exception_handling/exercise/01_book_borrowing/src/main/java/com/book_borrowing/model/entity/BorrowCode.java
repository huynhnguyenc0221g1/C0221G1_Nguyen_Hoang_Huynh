package com.book_borrowing.model.entity;

import javax.persistence.*;

@Entity
@Table(name = "borrow_code")
public class BorrowCode {
    @Id
    private Long id;
    @ManyToOne
    @JoinColumn(name = "book_id",referencedColumnName = "id")
    private Book book;

    public BorrowCode() {
    }

    public BorrowCode(Long id, Book book) {
        this.id = id;
        this.book = book;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public Book getBook() {
        return book;
    }

    public void setBook(Book book) {
        this.book = book;
    }
}
