package com.pfeffer.anotaaicatalog.infra.mongo.model;

import com.pfeffer.anotaaicatalog.core.category.CategoryDTO;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;

@Getter
@Setter
@NoArgsConstructor
@Document(collection = "categories")
public class Category {

    @Id
    private String id;

    private String title;

    private String description;

    private String ownerId;

    public Category(CategoryDTO dto) {
        this.title = dto.title();
        this.description = dto.description();
        this.ownerId = dto.ownerId();
    }

}
