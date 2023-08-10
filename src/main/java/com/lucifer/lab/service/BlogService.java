package com.lucifer.lab.service;

import com.lucifer.lab.modeldao.Blog;
import org.springframework.http.ResponseEntity;

import java.util.List;

public interface BlogService {


    Blog createBlog(Blog blog);


    List<Blog> getAllBlog();

    Blog getBlogById(Long id);


    boolean deleteBlog(Long id);


    Blog updateBlog(Long id, Blog blog);
}
