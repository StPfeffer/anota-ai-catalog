package com.pfeffer.anotaaicatalog.controllers;

import com.pfeffer.anotaaicatalog.core.product.ProductDTO;
import com.pfeffer.anotaaicatalog.infra.mongo.model.Product;
import com.pfeffer.anotaaicatalog.services.ProductService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/products")
public class ProductController {

    private final ProductService service;

    @Autowired
    public ProductController(ProductService service) {
        this.service = service;
    }

    @PostMapping
    public ResponseEntity<Product> create(@RequestBody ProductDTO dto) {
        Product category = this.service.create(dto);

        return new ResponseEntity<>(category, HttpStatus.CREATED);
    }

    @GetMapping
    public ResponseEntity<List<Product>> listAll() {
        List<Product> categories = this.service.getAll();

        return new ResponseEntity<>(categories, HttpStatus.OK);
    }

    @GetMapping("{id}")
    public ResponseEntity<Product> get(@PathVariable String id) {
        Product category = this.service.findById(id).orElse(null);

        return new ResponseEntity<>(category, HttpStatus.OK);
    }

    @PutMapping("{id}")
    public ResponseEntity<Product> update(@PathVariable String id, @RequestBody ProductDTO dto) {
        Product category = this.service.update(id, dto);

        return new ResponseEntity<>(category, HttpStatus.OK);
    }

    @DeleteMapping("{id}")
    public ResponseEntity<Product> delete(@PathVariable String id) {
        this.service.delete(id);

        return ResponseEntity.noContent().build();
    }

}
