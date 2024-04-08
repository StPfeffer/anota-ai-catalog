package com.pfeffer.anotaaicatalog.services;

import com.pfeffer.anotaaicatalog.core.MessageDTO;
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

    private final AwsSnsService snsService;

    public CategoryService(CategoryRepository repository, AwsSnsService snsService) {
        this.repository = repository;
        this.snsService = snsService;
    }

    public Category create(CategoryDTO dto) {
        Category category = new Category(dto);

        this.repository.save(category);
        this.snsService.publish(new MessageDTO(category.toString()));

        return category;
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

        this.repository.save(category);
        this.snsService.publish(new MessageDTO(category.toString()));

        return category;
    }

    public void delete(String id) {
        Category category = this.repository.findById(id)
                .orElseThrow(CategoryNotFoundException::new);

        this.repository.delete(category);
    }

}
