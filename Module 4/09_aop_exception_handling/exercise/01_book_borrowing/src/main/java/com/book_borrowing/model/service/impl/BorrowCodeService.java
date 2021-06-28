package com.book_borrowing.model.service.Impl;

import com.book_borrowing.model.entity.BorrowCode;
import com.book_borrowing.model.repository.IBorrowCodeRepository;
import com.book_borrowing.model.service.IBorrowCodeService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class BorrowCodeService implements IBorrowCodeService {
    @Autowired
    IBorrowCodeRepository borrowCodeRepository;
    @Override
    public List<BorrowCode> findAll() {
        return borrowCodeRepository.findAll();
    }

    @Override
    public void deleteById(Long id) {
        borrowCodeRepository.deleteById(id);
    }

    @Override
    public void create(BorrowCode borrowCode) {
        borrowCodeRepository.save(borrowCode);
    }

    @Override
    public BorrowCode findById(Long id) {
        return borrowCodeRepository.findById(id).orElse(null);
    }
}
