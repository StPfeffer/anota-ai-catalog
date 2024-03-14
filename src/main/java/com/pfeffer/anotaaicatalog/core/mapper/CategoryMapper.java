package com.pfeffer.anotaaicatalog.core.mapper;

import com.pfeffer.anotaaicatalog.core.dto.CategoryDTO;
import com.pfeffer.anotaaicatalog.core.entity.CategoryBO;

public class CategoryMapper {

    public CategoryDTO toDTO(CategoryBO bo) {
        CategoryDTO dto = new CategoryDTO();

        dto.setTitle(bo.getTitle());
        dto.setDescription(bo.getDescription());
        dto.setOwnerId(bo.getOwnerId());

        return dto;
    }

    public CategoryBO toBO(CategoryDTO dto) {
        CategoryBO bo = new CategoryBO();

        bo.setTitle(dto.getTitle());
        bo.setDescription(dto.getDescription());
        bo.setOwnerId(dto.getOwnerId());

        return bo;
    }

}
