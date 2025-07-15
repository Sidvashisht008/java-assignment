package com.product.repository;

import org.springframework.data.mongodb.repository.MongoRepository;

import com.product.entity.ProductEntity;

public interface ProductRepository extends MongoRepository<ProductEntity, String> {
	
}