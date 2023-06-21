package com.micro.blog.app.service;

import com.micro.blog.app.entity.Post;
import com.micro.blog.app.repository.PostRepository;
import com.micro.blog.app.vo.Category;
import com.micro.blog.app.vo.ResponseTemplate;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.client.RestTemplate;

import java.util.List;

@Service
@Slf4j
public class PostService {

    private RestTemplate restTemplate;

    private PostRepository postRepository;

    @Autowired

    public PostService(RestTemplate restTemplate, PostRepository postRepository){
        this.restTemplate = restTemplate;
        this.postRepository = postRepository;
    }


    public Post savePost(Post post) {
        return postRepository.save(post);
    }

    public ResponseTemplate findByPostId(int id) {
        log.info("Inside the find by post method in post service class");

        ResponseTemplate res = new ResponseTemplate();

        Post post = postRepository.findByPostId(id);

        Category category = restTemplate.getForObject("http://CATEGORY-SERVICE/categories/"+post.getCategoryId(),Category.class);

        res.setPost(post);
        res.setCategory(category);

        return  res;
    }

    public List<Post> findAllPosts() {
        return  postRepository.findAll();
    }

    public Post updatePost(int id, Post post) {
        return postRepository.save(post);
    }

    public void deletePost(int id){
        postRepository.deleteById(id);
    }
}
