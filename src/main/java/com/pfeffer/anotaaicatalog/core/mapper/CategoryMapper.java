package com.pfeffer.anotaaicatalog.core.mapper;

import com.pfeffer.anotaaicatalog.core.dto.CategoryDTO;
import com.pfeffer.anotaaicatalog.core.entity.CategoryBO;

public class CategoryMapper {

    public static CategoryDTO toDTO(CategoryBO bo) {
        CategoryDTO dto = new CategoryDTO();

        dto.setId(bo.getId());
        dto.setTitle(bo.getTitle());
        dto.setDescription(bo.getDescription());
        dto.setOwnerId(bo.getOwnerId());

        return dto;
    }

    public static CategoryBO toBO(CategoryDTO dto) {
        CategoryBO bo = new CategoryBO();

        bo.setId(dto.getId());
        bo.setTitle(dto.getTitle());
        bo.setDescription(dto.getDescription());
        bo.setOwnerId(dto.getOwnerId());

        return bo;
    }

}
