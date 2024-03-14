package com.pfeffer.anotaaicatalog.core.repository;

import com.pfeffer.anotaaicatalog.core.entity.CategoryBO;

public interface ICategoryDataBaseRepository {

    CategoryBO persist(CategoryBO bo);

}
