package com.survivingcodingbootcamp.blog.repository;

import com.survivingcodingbootcamp.blog.model.HashTag;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Component;

import java.util.Optional;

@Component
public interface HashTagRepository extends CrudRepository<HashTag,Long> {
    Optional<HashTag> findByHashTag(String hashTag);
}
