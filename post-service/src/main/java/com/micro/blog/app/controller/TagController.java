package com.micro.blog.app.controller;

import com.micro.blog.app.entity.Tag;
import com.micro.blog.app.service.TagService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("/tags/")
public class TagController {


    private TagService tagService;
    @Autowired
    public TagController(TagService tagService){
        this.tagService = tagService;
    }

    @PostMapping
    public Tag saveTag(@RequestBody Tag tag){
        return tagService.saveTag(tag);
    }

    @GetMapping("/{id}")
    public Optional<Tag> findByTagId(@PathVariable int id){
        return tagService.findByTagId(id);
    }

    @GetMapping
    public List<Tag> findAllTags(){
        return tagService.findAllTags();
    }

    @PutMapping("/{id}")
    public Tag updateTag(@PathVariable int id, @RequestBody Tag tag){
        tag.setId(id);
        return tagService.updateTag(id, tag);
    }

    @DeleteMapping("/id")
    public String deleteTag(@PathVariable int id){
        tagService.deleteByTagId(id);
        return  "Tag is deleted successfully";
    }


}
