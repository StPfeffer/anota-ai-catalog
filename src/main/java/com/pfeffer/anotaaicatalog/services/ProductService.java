package com.pfeffer.anotaaicatalog.services;

import com.pfeffer.anotaaicatalog.core.category.exception.CategoryNotFoundException;
import com.pfeffer.anotaaicatalog.core.product.ProductDTO;
import com.pfeffer.anotaaicatalog.core.product.exception.ProductNotFoundException;
import com.pfeffer.anotaaicatalog.infra.mongo.model.Category;
import com.pfeffer.anotaaicatalog.infra.mongo.model.Product;
import com.pfeffer.anotaaicatalog.infra.mongo.repository.ProductRepository;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class ProductService {

    private final ProductRepository repository;

    private final CategoryService categoryService;

    public ProductService(ProductRepository repository, CategoryService categoryService) {
        this.repository = repository;
        this.categoryService = categoryService;
    }

    public Product create(ProductDTO dto) {
        Category category = this.categoryService.findById(dto.categoryId())
                .orElseThrow(CategoryNotFoundException::new);

        if (category == null) {
            throw new CategoryNotFoundException();
        }

        Product newProduct = new Product(dto);
        newProduct.setCategory(category);

        return this.repository.save(newProduct);
    }

    public List<Product> getAll() {
        return this.repository.findAll();
    }

    public Optional<Product> findById(String id) {
        return this.repository.findById(id);
    }

    public Product update(String id, ProductDTO dto) {
        Product product = this.repository.findById(id)
                .orElseThrow(ProductNotFoundException::new);

        if (dto.categoryId() != null) {
            this.categoryService.findById(dto.categoryId())
                    .ifPresent(product::setCategory);
        }

        if (!dto.title().isEmpty()) {
            product.setTitle(dto.title());
        }

        if (!dto.description().isEmpty()) {
            product.setDescription(dto.description());
        }

        if (!(dto.price() == null)) {
            product.setPrice(dto.price());
        }

        return this.repository.save(product);
    }

    public void delete(String id) {
        Product product = this.repository.findById(id)
                .orElseThrow(ProductNotFoundException::new);

        this.repository.delete(product);
    }

}
