package com.micro.blog.app.controller;

import com.micro.blog.app.entity.Post;
import com.micro.blog.app.service.PostService;
import com.micro.blog.app.vo.ResponseTemplate;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/posts/")
public class PostController {

    private PostService postService;
    @Autowired
    public PostController(PostService postService){
        this.postService = postService;
    }

    @PostMapping
    public Post savePost(@RequestBody Post post){
        return postService.savePost(post);
    }

    @GetMapping("/{id}")
    public ResponseTemplate findByPostId(@PathVariable int id){
        return postService.findByPostId(id);
    }

    @GetMapping
    public List<Post> findAllPosts(){
        return postService.findAllPosts();
    }

    @PutMapping("/{id}")
    public Post updatePost(@PathVariable int id, @RequestBody Post post){
        post.setPostId(id);
        return postService.updatePost(id, post);
    }

    @DeleteMapping("/{id}")
    public String deletePost(@PathVariable int id){
        postService.deletePost(id);
        return "delete the post successfully" + id;
    }
}
