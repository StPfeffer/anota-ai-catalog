package com.pfeffer.anotaaicatalog.infra.mongo.model;

import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;

import java.math.BigDecimal;

@Document(collection = "products")
@Getter
@Setter
@NoArgsConstructor
public class Product {

    @Id
    private String id;

    private String title;

    private String description;

    private BigDecimal price;

    private String categoryId;

    private String ownerId;

}
