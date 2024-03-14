package com.pfeffer.anotaaicatalog.services;

import com.pfeffer.anotaaicatalog.core.dto.CategoryDTO;
import com.pfeffer.anotaaicatalog.core.mapper.CategoryMapper;
import com.pfeffer.anotaaicatalog.core.usecase.CreateCategory;
import com.pfeffer.anotaaicatalog.infra.mongo.mapper.MongoCategoryMapper;
import com.pfeffer.anotaaicatalog.infra.mongo.model.Category;
import com.pfeffer.anotaaicatalog.infra.mongo.repository.CategoryRepository;
import org.springframework.stereotype.Service;

@Service
public class CategoryService implements CreateCategory {

    private final CategoryRepository repository;

    public CategoryService(CategoryRepository repository) {
        this.repository = repository;
    }

    @Override
    public CategoryDTO create(CategoryDTO dto) {
        Category newCategory = new Category(dto);

        this.repository.save(newCategory);

        return CategoryMapper.toDTO(MongoCategoryMapper.toDomain(newCategory));
    }

}
