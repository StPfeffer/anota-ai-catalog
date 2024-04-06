package com.pfeffer.anotaaicatalog.services;

import com.pfeffer.anotaaicatalog.core.dto.ProductDTO;
import com.pfeffer.anotaaicatalog.core.exception.product.ProductNotFoundException;
import com.pfeffer.anotaaicatalog.core.mapper.ProductMapper;
import com.pfeffer.anotaaicatalog.core.usecase.product.CreateProduct;
import com.pfeffer.anotaaicatalog.core.usecase.product.DeleteProduct;
import com.pfeffer.anotaaicatalog.core.usecase.product.FindProduct;
import com.pfeffer.anotaaicatalog.core.usecase.product.UpdateProduct;
import com.pfeffer.anotaaicatalog.infra.mongo.mapper.MongoProductMapper;
import com.pfeffer.anotaaicatalog.infra.mongo.model.Product;
import com.pfeffer.anotaaicatalog.infra.mongo.repository.ProductRepository;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class ProductService implements CreateProduct, FindProduct, UpdateProduct, DeleteProduct {

    private final ProductRepository repository;

    private final CategoryService categoryService;

    public ProductService(ProductRepository repository, CategoryService categoryService) {
        this.repository = repository;
        this.categoryService = categoryService;
    }

    @Override
    public ProductDTO create(ProductDTO dto) {
        Product newProduct = new Product(dto);
        newProduct.setCategory(categoryService.findById(dto.categoryId()));

        this.repository.save(newProduct);

        return ProductMapper.toDTO(MongoProductMapper.toDomain(newProduct));
    }

    @Override
    public List<ProductDTO> getAll() {
        List<Product> products = this.repository.findAll();

        return products.stream()
                .map(MongoProductMapper::toDomain)
                .toList()
                .stream()
                .map(ProductMapper::toDTO)
                .toList();
    }

    @Override
    public ProductDTO find(String id) {
        Product product = this.repository.findById(id).orElse(null);

        if (product == null) {
            return null;
        }

        return ProductMapper.toDTO(MongoProductMapper.toDomain(product));
    }

    @Override
    public ProductDTO update(String id, ProductDTO dto) {
        Product product = this.repository.findById(id)
                .orElseThrow(ProductNotFoundException::new);

        if (!dto.title().isEmpty()) {
            product.setTitle(dto.title());
        }

        if (!dto.description().isEmpty()) {
            product.setDescription(dto.description());
        }

        this.repository.save(product);

        return ProductMapper.toDTO(MongoProductMapper.toDomain(product));
    }

    @Override
    public void delete(String id) {
        Product product = this.repository.findById(id)
                .orElseThrow(ProductNotFoundException::new);

        this.repository.delete(product);
    }

}
