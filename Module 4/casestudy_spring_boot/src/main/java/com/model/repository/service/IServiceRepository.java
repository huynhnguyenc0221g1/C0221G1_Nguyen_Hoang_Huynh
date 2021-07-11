package com.model.repository.service;

import com.model.entity.service.Service;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

@Repository
public interface IServiceRepository extends JpaRepository<Service,Long> {
    @Query(value = "select * from service s where s.service_name like %?1% && s.flag=1", nativeQuery = true)
    Page<Service> findAllByKeyWord(String keyWord, Pageable pageable);
}
