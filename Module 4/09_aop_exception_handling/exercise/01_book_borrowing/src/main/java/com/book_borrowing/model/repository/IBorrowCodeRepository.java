package com.book_borrowing.model.repository;

import com.book_borrowing.model.entity.BorrowCode;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface IBorrowCodeRepository extends JpaRepository<BorrowCode,Long> {
}
