package com.content.repository;

import org.springframework.data.mongodb.repository.MongoRepository;

import com.content.model.Unit;

public interface UnitRepository extends MongoRepository<Unit, String> {
}
