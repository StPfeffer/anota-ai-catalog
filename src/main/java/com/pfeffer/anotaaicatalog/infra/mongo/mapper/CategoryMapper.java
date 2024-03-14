package com.pfeffer.anotaaicatalog.infra.mongo.mapper;

import com.pfeffer.anotaaicatalog.core.entity.CategoryBO;
import com.pfeffer.anotaaicatalog.infra.mongo.model.Category;

public class CategoryMapper {

    public static CategoryBO toDomain(Category entity) {
        CategoryBO domain = new CategoryBO();

        domain.setId(entity.getId());
        domain.setTitle(entity.getTitle());
        domain.setDescription(entity.getDescription());
        domain.setOwnerId(entity.getOwnerId());

        return domain;
    }

    public static Category toEntity(CategoryBO domain) {
        Category entity = new Category();

        entity.setId(domain.getId());
        entity.setTitle(domain.getTitle());
        entity.setDescription(domain.getDescription());
        entity.setOwnerId(domain.getOwnerId());

        return entity;
    }

}
