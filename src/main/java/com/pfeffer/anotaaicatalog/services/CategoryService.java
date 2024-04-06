package com.pfeffer.anotaaicatalog.services;

import com.pfeffer.anotaaicatalog.core.dto.CategoryDTO;
import com.pfeffer.anotaaicatalog.core.exception.category.CategoryNotFoundException;
import com.pfeffer.anotaaicatalog.core.mapper.CategoryMapper;
import com.pfeffer.anotaaicatalog.core.usecase.category.CreateCategory;
import com.pfeffer.anotaaicatalog.core.usecase.category.DeleteCategory;
import com.pfeffer.anotaaicatalog.core.usecase.category.FindCategory;
import com.pfeffer.anotaaicatalog.core.usecase.category.UpdateCategory;
import com.pfeffer.anotaaicatalog.infra.mongo.mapper.MongoCategoryMapper;
import com.pfeffer.anotaaicatalog.infra.mongo.model.Category;
import com.pfeffer.anotaaicatalog.infra.mongo.repository.CategoryRepository;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class CategoryService implements CreateCategory, FindCategory, UpdateCategory, DeleteCategory {

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

    @Override
    public List<CategoryDTO> getAll() {
        List<Category> categories = this.repository.findAll();

        return categories.stream()
                .map(MongoCategoryMapper::toDomain)
                .toList()
                .stream()
                .map(CategoryMapper::toDTO)
                .toList();
    }

    @Override
    public CategoryDTO find(String id) {
        Category category = this.repository.findById(id).orElse(null);

        if (category == null) {
            return null;
        }

        return CategoryMapper.toDTO(MongoCategoryMapper.toDomain(category));
    }

    @Override
    public CategoryDTO update(String id, CategoryDTO dto) {
        Category category = this.repository.findById(id)
                .orElseThrow(CategoryNotFoundException::new);

        if (!dto.title().isEmpty()) {
            category.setTitle(dto.title());
        }

        if (!dto.description().isEmpty()) {
            category.setDescription(dto.description());
        }

        this.repository.save(category);

        return CategoryMapper.toDTO(MongoCategoryMapper.toDomain(category));
    }

    @Override
    public void delete(String id) {
        Category category = this.repository.findById(id)
                .orElseThrow(CategoryNotFoundException::new);

        this.repository.delete(category);
    }

}
