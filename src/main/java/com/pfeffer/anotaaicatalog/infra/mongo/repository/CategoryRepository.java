package com.pfeffer.anotaaicatalog.infra.mongo.repository;

import com.pfeffer.anotaaicatalog.infra.mongo.model.Category;
import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface CategoryRepository extends MongoRepository<Category, String> {
}
