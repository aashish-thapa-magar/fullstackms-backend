package com.content.repository;

import org.springframework.data.mongodb.repository.MongoRepository;

import com.content.model.Chapter;

public interface ChapterRepository extends MongoRepository<Chapter, String>{
}
