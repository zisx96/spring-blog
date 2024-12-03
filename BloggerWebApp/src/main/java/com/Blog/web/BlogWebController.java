package com.Blog.web;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.ModelAttribute;

import com.Blog.entity.Post;
import com.Blog.service.BlogWebService;

@Controller
public class BlogWebController {

    @Autowired
    private BlogWebService blogWebService;

    @GetMapping("/posts")
    public String getAllPosts(Model model) {
        List<Post> posts = blogWebService.getAllPosts();
        model.addAttribute("posts", posts);
        return "postList"; 
    }

    @GetMapping("/posts/new")
    public String createPostForm(Model model) {
        model.addAttribute("post", new Post());
        return "createPost"; 
    }

    @PostMapping("/posts")
    public String createNewPost(Post post) {
        blogWebService.addPost(post);
        return "redirect:/posts"; 
    }

    @GetMapping("/posts/edit/{id}")
    public String editPostForm(@PathVariable("id") Long id, Model model) {
        Post post = blogWebService.getPostById(id);
        if (post != null) {
            model.addAttribute("post", post);
            return "editPost"; 
        }
        return "redirect:/posts"; 
    }

    @PostMapping("/posts/edit")
    public String updatePost(@ModelAttribute("post") Post post) {
        blogWebService.updatePost(post);
        return "redirect:/posts"; 
    }

    @GetMapping("/posts/delete/{id}")
    public String deletePost(@PathVariable("id") Long id) {
        blogWebService.deletePost(id);
        return "redirect:/posts"; 
    }

    @GetMapping("/posts/view/{id}")
    public String viewPost(@PathVariable("id") Long id, Model model) {
        Post post = blogWebService.getPostById(id);
        if (post != null) {
            model.addAttribute("post", post);
            return "viewPost"; 
        }
        return "redirect:/posts"; 
    }
}
