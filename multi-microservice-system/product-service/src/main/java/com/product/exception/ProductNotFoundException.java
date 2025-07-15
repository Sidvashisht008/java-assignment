package com.product.exception;

public class ProductNotFoundException extends RuntimeException {
	
    /**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	public ProductNotFoundException(String id) {
        super("Product with ID " + id + " not found");
    }
    
}