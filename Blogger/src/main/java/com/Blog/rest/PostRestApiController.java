package com.Blog.rest;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.Blog.RestService.IPostService;
import com.Blog.entity.Post;

import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.tags.Tag;

@RestController
@RequestMapping("api/blog")
@Tag(name="Blogger API", description = "There are 5 apis to handle the request for the front end")
public class PostRestApiController {
	
	@Autowired
	private IPostService service;
	
	
	@PostMapping("create-post")
	@Operation(summary="Post Request which will create a new post")
	public ResponseEntity<Post> createNewPost(@RequestBody Post post) {
		
		Post res = service.addPost(post);
		
		return new ResponseEntity<Post>(res, HttpStatus.CREATED);
	}
	
	@GetMapping("get-post/{id}")
	@Operation(summary="Get Request which will get the post by post id")
	public ResponseEntity<Post> getThePostById(@PathVariable("id") Long id){
		
		Post post = service.getPostById(id);
		
		return new ResponseEntity<Post>(post, HttpStatus.OK);
	}
	
	@GetMapping("all-post")
	@Operation(summary="Get Request which show all the posts")
	public ResponseEntity<?> getAllPost() { 
		
		List<Post> post = service.getAllPosts();
		
		return new ResponseEntity<List<Post>>(post, HttpStatus.OK);
	}
	
	@DeleteMapping("delete-post/{id}")
	@Operation(summary="Delete Request to delete the post")
	public ResponseEntity<Void> deleteThePost(@PathVariable("id") Long id){
		
		service.deletePost(id);
		
		return new ResponseEntity<Void>(HttpStatus.OK);
	}
	
	@PutMapping("update-post")
	@Operation(summary="Put Request to update the post")
	public ResponseEntity<Void> updateThePost(@RequestBody Post post ){
		
		service.updatePost(post);
		
		return new ResponseEntity<Void>(HttpStatus.OK);
		
	}	

}
