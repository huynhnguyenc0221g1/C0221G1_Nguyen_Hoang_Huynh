package com.model.repository.employee;

import com.model.entity.employee.Employee;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

@Repository
public interface IEmployeeRepository extends JpaRepository<Employee,Long> {
    @Query(value = "select * from employee e where e.name like %?1% && e.flag=1", nativeQuery = true)
    Page<Employee> findAllByKeyWord(String keyWord, Pageable pageable);
}
