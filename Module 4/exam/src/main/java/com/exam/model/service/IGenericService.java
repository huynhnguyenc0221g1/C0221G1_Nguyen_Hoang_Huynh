package com.exam.model.service;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;

public interface IGenericService<T> {
    Page<T> findAll(String keyWord, Pageable pageable);
    T findById(Long id);
    void save(T t);
    void remove(Long id);
}