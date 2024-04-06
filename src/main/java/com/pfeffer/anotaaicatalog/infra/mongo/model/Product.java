package com.pfeffer.anotaaicatalog.infra.mongo.model;

import com.pfeffer.anotaaicatalog.core.product.ProductDTO;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;

import java.math.BigDecimal;

@Getter
@Setter
@NoArgsConstructor
@Document(collection = "products")
public class Product {

    @Id
    private String id;

    private String title;

    private String description;

    private BigDecimal price;

    private Category category;

    private String ownerId;

    public Product(ProductDTO dto) {
        this.title = dto.title();
        this.description = dto.description();
        this.price = dto.price();
        this.ownerId = dto.ownerId();
    }

}
