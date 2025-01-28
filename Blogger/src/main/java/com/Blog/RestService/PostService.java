package com.Blog.RestService;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.Blog.entity.Post;
import com.Blog.exceptions.PostNotFoundException;
import com.Blog.repo.IPostRepo;

@Service
public class PostService implements IPostService {
	
	private IPostRepo repo;
	
	@Autowired
	public void setIPostRepo(IPostRepo repo) {
		
		this.repo = repo;
	}
	
	@Override
	public Post addPost(Post post) {
		
		return repo.save(post);
	}

	@Override
	public List<Post> getAllPosts() {
		return repo.findAll();
	}

	@Override
	public Post getPostById(Long id) {
		
		Optional<Post> post = repo.findById(id);
		
		if(post.isPresent()) {
			
			return post.get();
		}
		else {
			
			throw new PostNotFoundException("Post not found with id: " + id);
		}
	}

	@Override
	public void deletePost(Long id) {
		
		Optional<Post> post = repo.findById(id);
		
		if(post.isPresent()){
			
			repo.deleteById(id);
			
		}
		else {
			
			throw new PostNotFoundException("Post not found with id: " + id);
		}
		
	}

	@Override
	public void updatePost(Post updatedPost,Long id) {
		
		Optional<Post> post = repo.findById(id);
		
		if(post.isPresent()) {

			Post existingPost = post.get();

			existingPost.setTitle(updatedPost.getTitle());
			existingPost.setContent(updatedPost.getContent());
			existingPost.setSubheading(updatedPost.getSubheading());
			existingPost.setAuthor(updatedPost.getAuthor());
			existingPost.setImageUrl(updatedPost.getImageUrl());

			repo.save(existingPost);
			
		}
		
		else {
			
			throw new PostNotFoundException("Post does not exist to update");
		}
		
	}

}
