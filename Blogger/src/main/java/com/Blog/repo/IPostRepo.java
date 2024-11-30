package com.Blog.repo;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.Blog.entity.Post;

@Repository
public interface IPostRepo extends JpaRepository<Post, Long> {
	
}
