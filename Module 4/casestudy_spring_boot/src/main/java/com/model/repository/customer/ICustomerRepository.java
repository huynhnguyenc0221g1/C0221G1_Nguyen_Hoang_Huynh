package com.model.repository.customer;

import com.model.entity.customer.Customer;
import com.model.entity.customer.CustomerType;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

@Repository
public interface ICustomerRepository extends JpaRepository<Customer,Long> {
    @Query(value = "select * from customer where customer_name like %?1% && flag=1", nativeQuery = true)
    Page<Customer> findAllByKeyWord(String keyWord, Pageable pageable);
}
