package com.pfeffer.anotaaicatalog.infra.mongo.model;

import com.pfeffer.anotaaicatalog.core.product.ProductDTO;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import org.json.JSONObject;
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

    private String ownerId;

    private String categoryId;

    public Product(ProductDTO dto) {
        this.title = dto.title();
        this.description = dto.description();
        this.price = dto.price();
        this.ownerId = dto.ownerId();
        this.categoryId = dto.categoryId();
    }

    @Override
    public String toString() {
        JSONObject json = new JSONObject();

        json.put("id", this.id);
        json.put("title", this.title);
        json.put("description", this.description);
        json.put("price", this.price);
        json.put("ownerId", this.ownerId);
        json.put("categoryId", this.categoryId);
        json.put("type", "product");

        return json.toString();
    }

}
