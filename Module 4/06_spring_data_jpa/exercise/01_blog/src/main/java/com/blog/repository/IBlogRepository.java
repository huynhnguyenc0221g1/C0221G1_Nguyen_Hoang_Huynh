package com.blog.repository;

import com.blog.entity.Blog;
import org.springframework.data.repository.CrudRepository;
import org.springframework.data.repository.PagingAndSortingRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface IBlogRepository extends CrudRepository<Blog, Long> {
}
