package com.pfeffer.anotaaicatalog.core.usecase.product;

import com.pfeffer.anotaaicatalog.core.dto.ProductDTO;

public interface UpdateProduct {

    ProductDTO update(String id, ProductDTO bo);

}
