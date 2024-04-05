package com.pfeffer.anotaaicatalog.core.usecase.product;

import com.pfeffer.anotaaicatalog.core.dto.ProductDTO;

import java.util.List;

public interface FindProduct {

    ProductDTO find(String id);

    List<ProductDTO> getAll();

}
