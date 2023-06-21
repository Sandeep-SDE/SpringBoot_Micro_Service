package com.micro.tag.service.controller;

import com.micro.tag.service.entity.Tag;
import com.micro.tag.service.service_provider.TagService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.Optional;

@RestController
@RequestMapping("/tags")
@Slf4j
public class TagController {
    @Autowired
    private TagService tagService;

    @PostMapping
    public Tag saveTag(@RequestBody Tag tag){
        log.info("This post mapping call in saveTag method in TagController class");
        return tagService.saveTag(tag);
    }

    @GetMapping("/{tagId}")
    public Optional<Tag> findByTagId(@PathVariable int tagId){
        log.info("This get mapping call in findByTagId method in TagController class");
        return tagService.findByTagId(tagId);
    }

}
