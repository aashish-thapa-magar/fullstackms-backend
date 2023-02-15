package com.content.repository;

import org.springframework.data.mongodb.repository.MongoRepository;

import com.content.model.Course;

public interface CourseRepository extends MongoRepository<Course, String>{
}
