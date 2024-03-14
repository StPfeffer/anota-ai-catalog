package com.pfeffer.anotaaicatalog.core.mapper;

import com.pfeffer.anotaaicatalog.core.dto.ProductDTO;
import com.pfeffer.anotaaicatalog.core.entity.ProductBO;

public class ProductMapper {

    public static ProductDTO toDTO(ProductBO bo) {
        ProductDTO dto = new ProductDTO();

        dto.setId(bo.getId());
        dto.setTitle(bo.getTitle());
        dto.setDescription(bo.getDescription());
        dto.setPrice(bo.getPrice());
        dto.setCategoryId(bo.getCategoryId());
        dto.setOwnerId(bo.getOwnerId());

        return dto;
    }

    public static ProductBO toBO(ProductDTO dto) {
        ProductBO bo = new ProductBO();

        bo.setId(dto.getId());
        bo.setTitle(dto.getTitle());
        bo.setDescription(dto.getDescription());
        bo.setPrice(dto.getPrice());
        bo.setCategoryId(dto.getCategoryId());
        bo.setOwnerId(dto.getOwnerId());

        return bo;
    }

}
