package com.lucifer.lab.repository;

import com.lucifer.lab.entity.BlogEntity;
import com.lucifer.lab.modeldao.Blog;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;


@Repository
public interface BlogRepository extends JpaRepository<BlogEntity, Long> {

}
