package com.pfeffer.anotaaicatalog.core.repository;

import com.pfeffer.anotaaicatalog.core.entity.ProductBO;

public interface IProductDataBaseRepository {

    ProductBO persist(ProductBO bo);

}
