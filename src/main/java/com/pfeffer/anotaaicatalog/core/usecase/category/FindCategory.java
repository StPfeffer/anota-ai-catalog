package com.pfeffer.anotaaicatalog.core.usecase.category;

import com.pfeffer.anotaaicatalog.core.dto.CategoryDTO;

import java.util.List;

public interface FindCategory {

    CategoryDTO findCategory(String id);

    List<CategoryDTO> getAll();

}
