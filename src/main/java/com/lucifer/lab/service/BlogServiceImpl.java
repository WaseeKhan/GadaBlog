package com.lucifer.lab.service;

import com.lucifer.lab.entity.BlogEntity;
import com.lucifer.lab.modeldao.Blog;
import com.lucifer.lab.repository.BlogRepository;
import org.slf4j.ILoggerFactory;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

import java.util.Date;
import java.util.List;
import java.util.stream.Collectors;

@Service
public class BlogServiceImpl implements BlogService{

    Logger logger = LoggerFactory.getLogger(BlogServiceImpl.class);
    @Autowired
    private BlogRepository blogRepository;
    @Override
    public Blog createBlog(Blog blog) {
        BlogEntity blogEntity = new BlogEntity();

        BeanUtils.copyProperties(blog, blogEntity);
        blog.setCreateOn(new Date());
        blog.setUpdatedOn(new Date());

        logger.info("Inside createBlog {}", blogEntity);

        blogRepository.save(blogEntity);
        return blog;
    }

    @Override
    public List<Blog> getAllBlog() {
        List<BlogEntity> blogEntities = blogRepository.findAll();
        List<Blog> blogs = blogEntities
                .stream()
                .map(blog-> new Blog(
                blog.getId(),
                blog.getTitle(),
                blog.getContent(),
                blog.getCreateOn(),
                blog.getUpdatedOn()))
                .collect(Collectors.toList());
        return blogs;
    }

    @Override
    public Blog getBlogById(Long id) {
        BlogEntity blogEntity = blogRepository.findById(id).get();
        Blog blog = new Blog();
        BeanUtils.copyProperties(blogEntity, blog);
        return blog;
    }

    @Override
    public boolean deleteBlog(Long id) {
        BlogEntity blogEntity = blogRepository.findById(id).get();
        blogRepository.delete(blogEntity);
        return true;
    }

    @Override
    public Blog updateBlog(Long id, Blog blog) {
        BlogEntity blogEntity = blogRepository.findById(id).get();

        blogEntity.setTitle(blog.getTitle());
        blogEntity.setContent(blog.getContent());
        blogRepository.save(blogEntity);
        return blog;
    }


}
