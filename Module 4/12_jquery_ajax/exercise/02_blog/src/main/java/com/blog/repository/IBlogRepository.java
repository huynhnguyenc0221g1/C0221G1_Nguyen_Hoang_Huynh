package com.blog.repository;

import com.blog.entity.Blog;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.PagingAndSortingRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface IBlogRepository extends JpaRepository<Blog, Long> {
    @Query("SELECT b FROM blog b")
    public List<Blog> findAllBlog();

    @Query("SELECT b FROM blog b WHERE b.title LIKE %?1%")
    public Page<Blog> searchBlogByTitle(String nameTitle,Pageable pageable);

    @Query("SELECT b FROM blog b WHERE b.title LIKE %?1%")
    public List<Blog> searchBlogByTitle(String nameTitle);

    @Query("SELECT b FROM blog b WHERE b.category.name LIKE %?1%")
    public List<Blog> searchBlogByCategory(String nameCategory);
}
