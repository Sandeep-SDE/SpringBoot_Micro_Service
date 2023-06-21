package com.micro.blog.app.repository;

import com.micro.blog.app.entity.Post;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.rest.core.annotation.RepositoryRestResource;

@RepositoryRestResource
public interface PostRepository extends JpaRepository<Post, Integer> {
    Post findByPostId(int id);
}
