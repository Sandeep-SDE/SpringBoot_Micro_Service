package com.micro.tag.service.service_provider;

import com.micro.tag.service.entity.Tag;
import com.micro.tag.service.repository.TagRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Optional;

@Service
public class TagService {

    @Autowired
    private TagRepository tagRepository;


    public Tag saveTag(Tag tag) {
        return tagRepository.save(tag);
    }

    public Optional<Tag> findByTagId(int tagId) {

        return tagRepository.findById(tagId);

    }
}
