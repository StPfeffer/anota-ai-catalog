package com.pfeffer.anotaaicatalog.services;

import com.pfeffer.anotaaicatalog.core.dto.ProductDTO;
import com.pfeffer.anotaaicatalog.core.mapper.ProductMapper;
import com.pfeffer.anotaaicatalog.core.usecase.CreateProduct;
import com.pfeffer.anotaaicatalog.infra.mongo.mapper.MongoProductMapper;
import com.pfeffer.anotaaicatalog.infra.mongo.model.Product;
import com.pfeffer.anotaaicatalog.infra.mongo.repository.CategoryRepository;
import com.pfeffer.anotaaicatalog.infra.mongo.repository.ProductRepository;
import org.springframework.stereotype.Service;

@Service
public class ProductService implements CreateProduct {

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

}
