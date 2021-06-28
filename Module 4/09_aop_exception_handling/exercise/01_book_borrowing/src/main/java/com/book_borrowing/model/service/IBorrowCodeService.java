package com.book_borrowing.model.service;

import com.book_borrowing.model.entity.BorrowCode;

import java.util.List;

public interface IBorrowCodeService {
    List<BorrowCode> findAll();

    void deleteById(Long id);

    void create(BorrowCode borrowCode);

    BorrowCode findById(Long id);
}
