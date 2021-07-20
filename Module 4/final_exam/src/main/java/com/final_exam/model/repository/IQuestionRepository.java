package com.final_exam.model.repository;

import com.final_exam.model.entity.Question;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

@Repository
public interface IQuestionRepository extends JpaRepository<Question,Long> {
    @Query(value = "select  * from question where title like %?1% && flag=1 order by status desc, date desc", nativeQuery = true)
    Page<Question> findAllByKeyWord(String keyWord, Pageable pageable);
}
