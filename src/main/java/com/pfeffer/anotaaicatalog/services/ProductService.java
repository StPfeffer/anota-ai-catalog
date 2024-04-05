package com.pfeffer.anotaaicatalog.services;

import com.pfeffer.anotaaicatalog.core.dto.ProductDTO;
import com.pfeffer.anotaaicatalog.core.exceptions.product.ProductNotFoundException;
import com.pfeffer.anotaaicatalog.core.mapper.ProductMapper;
import com.pfeffer.anotaaicatalog.core.usecase.product.CreateProduct;
import com.pfeffer.anotaaicatalog.core.usecase.product.DeleteProduct;
import com.pfeffer.anotaaicatalog.core.usecase.product.FindProduct;
import com.pfeffer.anotaaicatalog.core.usecase.product.UpdateProduct;
import com.pfeffer.anotaaicatalog.infra.mongo.mapper.MongoProductMapper;
import com.pfeffer.anotaaicatalog.infra.mongo.model.Product;
import com.pfeffer.anotaaicatalog.infra.mongo.repository.CategoryRepository;
import com.pfeffer.anotaaicatalog.infra.mongo.repository.ProductRepository;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class ProductService implements CreateProduct, FindProduct, UpdateProduct, DeleteProduct {

    private final ProductRepository repository;

    private final CategoryRepository categoryRepository;

    public ProductService(ProductRepository repository, CategoryRepository categoryRepository) {
        this.repository = repository;
        this.categoryRepository = categoryRepository;
    }

    @Override
    public ProductDTO create(ProductDTO dto) {
        Product newProduct = new Product(dto);
        newProduct.setCategory(categoryRepository.findById(dto.getCategoryId()).orElse(null));

        this.repository.save(newProduct);

        return ProductMapper.toDTO(MongoProductMapper.toDomain(newProduct));
    }

    @Override
    public List<ProductDTO> getAll() {
        List<Product> categories = this.repository.findAll();

        return categories.stream()
                .map(MongoProductMapper::toDomain)
                .toList()
                .stream()
                .map(ProductMapper::toDTO)
                .toList();
    }

    @Override
    public ProductDTO find(String id) {
        Product category = this.repository.findById(id).orElse(null);

        if (category == null) {
            return null;
        }

        return ProductMapper.toDTO(MongoProductMapper.toDomain(category));
    }

    @Override
    public ProductDTO update(String id, ProductDTO dto) {
        Product category = this.repository.findById(id)
                .orElseThrow(ProductNotFoundException::new);

        if (!dto.getTitle().isEmpty()) {
            category.setTitle(dto.getTitle());
        }

        if (!dto.getDescription().isEmpty()) {
            category.setDescription(dto.getDescription());
        }

        this.repository.save(category);

        return ProductMapper.toDTO(MongoProductMapper.toDomain(category));
    }

    @Override
    public void delete(String id) {
        Product category = this.repository.findById(id)
                .orElseThrow(ProductNotFoundException::new);

        this.repository.delete(category);
    }

}
