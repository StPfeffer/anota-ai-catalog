package com.pfeffer.anotaaicatalog.core.mapper;

import com.pfeffer.anotaaicatalog.core.dto.CategoryDTO;
import com.pfeffer.anotaaicatalog.core.entity.CategoryBO;

public class CategoryMapper {

    public static CategoryDTO toDTO(CategoryBO bo) {
        return new CategoryDTO(
                bo.getId(),
                bo.getTitle(),
                bo.getDescription(),
                bo.getOwnerId()
        );
    }

    public static CategoryBO toBO(CategoryDTO dto) {
        CategoryBO bo = new CategoryBO();

        bo.setId(dto.id());
        bo.setTitle(dto.title());
        bo.setDescription(dto.description());
        bo.setOwnerId(dto.ownerId());

        return bo;
    }

}
