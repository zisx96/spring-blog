package com.Blog.RestService;

import java.util.List;

import com.Blog.entity.Post;

public interface IPostService {
	
	Post addPost(Post post);
    List<Post> getAllPosts();
    Post getPostById(Long id);
    String deletePost(Long id);
    String updatePost(Post updatedPost);

}