package com.springboot.OMS.service;

import java.util.List;

import com.springboot.OMS.model.Product;

public interface ProductService {
	
	List<Product> getAllProducts();
	void saveProduct(Product product);
	Product getProductByID(long id);
	void deleteProductByID(long id);

}
