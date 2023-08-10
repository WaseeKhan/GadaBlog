package com.lucifer.lab.controller;

import com.lucifer.lab.modeldao.Blog;
import com.lucifer.lab.service.BlogService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

@RestController
@RequestMapping("/api")
public class BlogController {

    @Autowired
    private BlogService blogService;

    @PostMapping("/blog")
    public Blog createBlog(@RequestBody Blog blog){
        return blogService.createBlog(blog);

    }

    @GetMapping("/blogs")
    public List<Blog> getAllBlog(){
        return blogService.getAllBlog();
    }

    @GetMapping("/blog/{id}")
    public Blog getBlogById(@PathVariable Long id){
        return blogService.getBlogById(id);
    }

    @DeleteMapping("/blog/{id}")
    public ResponseEntity<Map<String, Boolean>> deleteBlog(@PathVariable Long id){
        boolean deleted = false;
        deleted = blogService.deleteBlog(id);
        Map<String, Boolean> response = new HashMap<>();
        response.put("Delete", deleted);
        return ResponseEntity.ok(response);
    }

    @PutMapping("/blog/{id}")
    public ResponseEntity<Blog> updateBlog(@PathVariable Long id,
                           @RequestBody Blog blog){

        Blog blog1 = blogService.updateBlog(id, blog);
        return ResponseEntity.ok(blog1);

    }
}
