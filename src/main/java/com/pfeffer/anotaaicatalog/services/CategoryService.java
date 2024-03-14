package com.pfeffer.anotaaicatalog.services;

import com.pfeffer.anotaaicatalog.core.dto.CategoryDTO;
import com.pfeffer.anotaaicatalog.core.usecase.CreateCategory;
import com.pfeffer.anotaaicatalog.infra.mongo.repository.CategoryRepository;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

@Service
public class CategoryService {

    private final CategoryRepository repository;

    public CategoryService(CategoryRepository repository) {
        this.repository = repository;
    }

    @Transactional
    public CategoryDTO create(CategoryDTO dto) {
        CreateCategory createCategory = new CreateCategory(repository);

        return createCategory.execute(dto);
    }

}
