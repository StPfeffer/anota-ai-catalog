package com.pfeffer.anotaaicatalog.controllers;

import com.pfeffer.anotaaicatalog.core.category.CategoryDTO;
import com.pfeffer.anotaaicatalog.infra.mongo.model.Category;
import com.pfeffer.anotaaicatalog.services.CategoryService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("api/categories")
public class CategoryController {

    private final CategoryService service;

    @Autowired
    public CategoryController(CategoryService service) {
        this.service = service;
    }

    @PostMapping
    public ResponseEntity<Category> create(@RequestBody CategoryDTO dto) {
        Category category = this.service.create(dto);

        return new ResponseEntity<>(category, HttpStatus.CREATED);
    }

    @GetMapping
    public ResponseEntity<List<Category>> listAll() {
        List<Category> categories = this.service.getAll();

        return new ResponseEntity<>(categories, HttpStatus.OK);
    }

    @GetMapping("{id}")
    public ResponseEntity<Category> get(@PathVariable String id) {
        Category category = this.service.findById(id).orElse(null);

        return new ResponseEntity<>(category, HttpStatus.OK);
    }

    @PutMapping("{id}")
    public ResponseEntity<Category> update(@PathVariable String id, @RequestBody CategoryDTO dto) {
        Category category = this.service.update(id, dto);

        return new ResponseEntity<>(category, HttpStatus.OK);
    }

    @DeleteMapping("{id}")
    public ResponseEntity<Category> delete(@PathVariable String id) {
        this.service.delete(id);

        return ResponseEntity.noContent().build();
    }

}
