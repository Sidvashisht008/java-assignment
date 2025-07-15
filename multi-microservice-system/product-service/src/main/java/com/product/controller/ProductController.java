package com.product.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.product.entity.ProductEntity;
import com.product.service.ProductService;

@RestController
@RequestMapping("/products")
public class ProductController {

    @Autowired
    private ProductService productService;

    @PostMapping
    public ProductEntity create(@RequestBody ProductEntity product) {
        return productService.create(product);
    }

    @GetMapping("/{id}")
    public ProductEntity get(@PathVariable String id) {
        return productService.getById(id);
    }

    @GetMapping
    public List<ProductEntity> getAll() {
        return productService.getAll();
    }

    @PutMapping("/{id}")
    public ProductEntity update(@PathVariable String id, @RequestBody ProductEntity product) {
        return productService.update(id, product);
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<String> delete(@PathVariable String id) {
        productService.delete(id);
        return ResponseEntity.ok("Product deleted");
    }
}
