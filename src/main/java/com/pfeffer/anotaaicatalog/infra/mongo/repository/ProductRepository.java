package com.pfeffer.anotaaicatalog.infra.mongo.repository;

import com.pfeffer.anotaaicatalog.core.repository.IProductDataBaseRepository;
import com.pfeffer.anotaaicatalog.infra.mongo.model.Product;
import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface ProductRepository extends MongoRepository<Product, String>, IProductDataBaseRepository {
}
