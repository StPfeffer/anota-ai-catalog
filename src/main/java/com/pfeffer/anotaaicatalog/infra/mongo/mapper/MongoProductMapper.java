package com.pfeffer.anotaaicatalog.infra.mongo.mapper;

import com.pfeffer.anotaaicatalog.core.entity.ProductBO;
import com.pfeffer.anotaaicatalog.infra.mongo.model.Product;

public class MongoProductMapper {

    public static ProductBO toDomain(Product entity) {
        ProductBO domain = new ProductBO();

        domain.setId(entity.getId());
        domain.setTitle(entity.getTitle());
        domain.setDescription(entity.getDescription());
        domain.setPrice(entity.getPrice());
        domain.setCategoryId(entity.getCategory().getId());
        domain.setOwnerId(entity.getOwnerId());

        return domain;
    }

    public static Product toEntity(ProductBO domain) {
        Product entity = new Product();

        entity.setId(domain.getId());
        entity.setTitle(domain.getTitle());
        entity.setDescription(domain.getDescription());
        entity.setPrice(domain.getPrice());
        entity.setOwnerId(domain.getOwnerId());

        return entity;
    }

}
