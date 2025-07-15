package com.product.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.product.entity.ProductEntity;
import com.product.exception.ProductNotFoundException;
import com.product.repository.ProductRepository;

@Service
public class ProductService {

    @Autowired
    private ProductRepository productRepo;

    public ProductEntity create(ProductEntity product) {
        return productRepo.save(product);
    }

    public ProductEntity getById(String id) {
        return productRepo.findById(id).orElseThrow(() -> new ProductNotFoundException(id));
    }

    public List<ProductEntity> getAll() {
        return productRepo.findAll();
    }

    public ProductEntity update(String id, ProductEntity updated) {
        ProductEntity existing = getById(id);
        existing.setName(updated.getName());
        existing.setPrice(updated.getPrice());
        existing.setAvailable(updated.isAvailable());
        return productRepo.save(existing);
    }

    public void delete(String id) {
        if (!productRepo.existsById(id)) {
            throw new ProductNotFoundException(id);
        }
        productRepo.deleteById(id);
    }
}