package com.Blog.service;

import java.util.List;

import com.Blog.entity.Post;

public interface IBlogWebService {


    Post addPost(Post post);

    Post getPostById(Long id);

    List<Post> getAllPosts();

    void deletePost(Long id);

    Post updatePost(Post post);
	
}
