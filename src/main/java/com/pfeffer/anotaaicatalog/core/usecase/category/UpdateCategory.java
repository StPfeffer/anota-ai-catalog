package com.pfeffer.anotaaicatalog.core.usecase.category;

import com.pfeffer.anotaaicatalog.core.dto.CategoryDTO;

public interface UpdateCategory {

    CategoryDTO update(String id, CategoryDTO bo);

}
