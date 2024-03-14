package com.pfeffer.anotaaicatalog.core.usecase;

import com.pfeffer.anotaaicatalog.core.dto.CategoryDTO;
import com.pfeffer.anotaaicatalog.core.entity.CategoryBO;
import com.pfeffer.anotaaicatalog.core.mapper.CategoryMapper;
import com.pfeffer.anotaaicatalog.core.repository.ICategoryDataBaseRepository;

public class CreateCategory {

    private final ICategoryDataBaseRepository repository;

    public CreateCategory(ICategoryDataBaseRepository repository) {
        this.repository = repository;
    }

    public CategoryDTO execute(CategoryDTO dto) {
        CategoryBO entity = repository.persist(CategoryMapper.toBO(dto));

        return CategoryMapper.toDTO(entity);
    }

}
