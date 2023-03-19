package com.springboot.OMS.service;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.springboot.OMS.model.Product;
import com.springboot.OMS.repository.ProductRepository;

@Service
public class ProductServiceImpl implements ProductService {
	
	@Autowired
	private ProductRepository repo;

	@Override
	public List<Product> getAllProducts() {
		// TODO Auto-generated method stub
		return repo.findAll();
	}

	@Override
	public void saveProduct(Product product) {
		// TODO Auto-generated method stub
		this.repo.save(product);
	}

	@Override
	public Product getProductByID(long id) {
		Optional<Product> optional = repo.findById(id);
		Product product = null;
		if(optional.isPresent()) {
			product = optional.get();
		}else {
			throw new RuntimeException(" Product not found for id :: " + id);
		}
		return product;
	}

	@Override
	public void deleteProductByID(long id) {
		this.repo.deleteById(id);
	}
}
