package com.pfeffer.anotaaicatalog.controllers;

import com.pfeffer.anotaaicatalog.core.dto.CategoryDTO;
import com.pfeffer.anotaaicatalog.services.CategoryService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("api/category")
public class CategoryController {

    private final CategoryService service;

    @Autowired
    public CategoryController(CategoryService service) {
        this.service = service;
    }

    @PostMapping
    public ResponseEntity<CategoryDTO> create(@RequestBody CategoryDTO dto) {
        CategoryDTO category = this.service.create(dto);

        return new ResponseEntity<>(category, HttpStatus.CREATED);
    }

    @GetMapping
    public ResponseEntity<List<CategoryDTO>> listAll() {
        List<CategoryDTO> categories = this.service.getAll();

        return new ResponseEntity<>(categories, HttpStatus.OK);
    }

    @GetMapping("{id}")
    public ResponseEntity<CategoryDTO> get(@PathVariable String id) {
        CategoryDTO category = this.service.find(id);

        return new ResponseEntity<>(category, HttpStatus.OK);
    }

    @PutMapping("{id}")
    public ResponseEntity<CategoryDTO> update(@PathVariable String id, @RequestBody CategoryDTO dto) {
        CategoryDTO category = this.service.update(id, dto);

        return new ResponseEntity<>(category, HttpStatus.OK);
    }

    @DeleteMapping("{id}")
    public ResponseEntity<CategoryDTO> delete(@PathVariable String id) {
        this.service.delete(id);

        return ResponseEntity.noContent().build();
    }

}
