package com.micro.blog.app.service;

import com.micro.blog.app.entity.Tag;
import com.micro.blog.app.repository.TagRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class TagService {

    @Autowired
    private TagRepository tagRepository;

    public Tag saveTag(Tag tag) {
        return tagRepository.save(tag);
    }

    public Optional<Tag> findByTagId(int id) {
        return tagRepository.findById(id);
    }

    public List<Tag> findAllTags() {
        return  tagRepository.findAll();
    }

    public Tag updateTag(int id, Tag tag) {
        return tagRepository.save(tag);
    }

    public void deleteByTagId(int id) {
        tagRepository.deleteById(id);
    }
}

