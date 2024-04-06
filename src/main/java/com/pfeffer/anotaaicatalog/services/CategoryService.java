package com.pfeffer.anotaaicatalog.services;

import com.pfeffer.anotaaicatalog.core.category.CategoryDTO;
import com.pfeffer.anotaaicatalog.core.category.exception.CategoryNotFoundException;
import com.pfeffer.anotaaicatalog.infra.mongo.model.Category;
import com.pfeffer.anotaaicatalog.infra.mongo.repository.CategoryRepository;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class CategoryService {

    private final CategoryRepository repository;

    public CategoryService(CategoryRepository repository) {
        this.repository = repository;
    }

    public Category create(CategoryDTO dto) {
        Category newCategory = new Category(dto);

        return this.repository.save(newCategory);
    }

    public List<Category> getAll() {
        return this.repository.findAll();
    }

    public Optional<Category> findById(String id) {
        return this.repository.findById(id);
    }

    public Category update(String id, CategoryDTO dto) {
        Category category = this.repository.findById(id)
                .orElseThrow(CategoryNotFoundException::new);

        if (!dto.title().isEmpty()) {
            category.setTitle(dto.title());
        }

        if (!dto.description().isEmpty()) {
            category.setDescription(dto.description());
        }

        return this.repository.save(category);
    }

    public void delete(String id) {
        Category category = this.repository.findById(id)
                .orElseThrow(CategoryNotFoundException::new);

        this.repository.delete(category);
    }

}
