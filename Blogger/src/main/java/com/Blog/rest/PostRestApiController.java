package com.Blog.rest;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import com.Blog.RestService.IPostService;
import com.Blog.entity.Post;

import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.tags.Tag;

@RestController
@CrossOrigin
@RequestMapping("api/blog")
@Tag(name="Blogger API", description = "There are 5 apis to handle the request for the front end")
public class PostRestApiController {
	
	@Autowired
	private IPostService service;
	
	
	@PostMapping()
	@Operation(summary="Post Request which will create a new post")
	public ResponseEntity<Post> createNewPost(@RequestBody Post post) {
		
		Post res = service.addPost(post);
		
		return new ResponseEntity<Post>(res, HttpStatus.CREATED);
	}
	
	@GetMapping("/{id}")
	@Operation(summary="Get Request which will get the post by post id")
	public ResponseEntity<Post> getThePostById(@PathVariable("id") Long id){
		
		Post post = service.getPostById(id);
		
		return new ResponseEntity<Post>(post, HttpStatus.OK);
	}
	
	@GetMapping()
	@Operation(summary="Get Request which show all the posts")
	public ResponseEntity<?> getAllPost() { 
		
		List<Post> post = service.getAllPosts();
		
		return new ResponseEntity<List<Post>>(post, HttpStatus.OK);
	}
	
	@DeleteMapping("/{id}")
	@Operation(summary="Delete Request to delete the post")
	public ResponseEntity<Void> deleteThePost(@PathVariable("id") Long id){
		
		service.deletePost(id);
		
		return new ResponseEntity<Void>(HttpStatus.OK);
	}
	
	@PutMapping("/{id}")
	@Operation(summary="Put Request to update the post")
	public ResponseEntity<Void> updateThePost(@RequestBody Post post, @PathVariable("id") Long id){
		
		service.updatePost(post, id);
		
		return new ResponseEntity<Void>(HttpStatus.OK);
		
	}	

}
