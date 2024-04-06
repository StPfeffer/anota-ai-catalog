package com.pfeffer.anotaaicatalog.core.mapper;

import com.pfeffer.anotaaicatalog.core.dto.ProductDTO;
import com.pfeffer.anotaaicatalog.core.entity.ProductBO;

public class ProductMapper {

    public static ProductDTO toDTO(ProductBO bo) {
        return new ProductDTO(
                bo.getId(),
                bo.getTitle(),
                bo.getDescription(),
                bo.getPrice(),
                bo.getCategoryId(),
                bo.getOwnerId()
        );
    }

    public static ProductBO toBO(ProductDTO dto) {
        ProductBO bo = new ProductBO();

        bo.setId(dto.id());
        bo.setTitle(dto.title());
        bo.setDescription(dto.description());
        bo.setPrice(dto.price());
        bo.setCategoryId(dto.categoryId());
        bo.setOwnerId(dto.ownerId());

        return bo;
    }

}
