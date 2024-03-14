package com.pfeffer.anotaaicatalog.core.usecase;

import com.pfeffer.anotaaicatalog.core.dto.ProductDTO;
import com.pfeffer.anotaaicatalog.core.entity.ProductBO;
import com.pfeffer.anotaaicatalog.core.mapper.ProductMapper;
import com.pfeffer.anotaaicatalog.core.repository.IProductDataBaseRepository;

public class CreateProduct {

    private final IProductDataBaseRepository repository;

    public CreateProduct(IProductDataBaseRepository repository) {
        this.repository = repository;
    }

    public ProductDTO execute(ProductDTO dto) {
        ProductBO entity = repository.persist(ProductMapper.toBO(dto));

        return ProductMapper.toDTO(entity);
    }

}
