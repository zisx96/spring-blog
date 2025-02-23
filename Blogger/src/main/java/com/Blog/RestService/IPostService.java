package com.Blog.RestService;

import java.util.List;

import com.Blog.entity.Post;

public interface IPostService {
	
	Post addPost(Post post);
    List<Post> getAllPosts();
    Post getPostById(Long id);
    void deletePost(Long id);
    void updatePost(Post updatedPost,Long id);

}
