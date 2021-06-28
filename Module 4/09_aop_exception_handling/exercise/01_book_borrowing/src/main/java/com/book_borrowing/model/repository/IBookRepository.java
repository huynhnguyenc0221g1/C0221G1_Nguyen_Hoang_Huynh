package com.book_borrowing.model.repository;

import com.book_borrowing.model.entity.Book;
import org.springframework.data.jpa.repository.JpaRepository;

public interface IBookRepository extends JpaRepository<Book,Integer> {
}
