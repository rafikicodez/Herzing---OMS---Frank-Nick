package com.springboot.OMS.controller;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;

import com.springboot.OMS.model.Product;
import com.springboot.OMS.service.ProductService;



@Controller
public class ProductController {
	
	@Autowired
	private ProductService product_service;
	
	
	// display home page
	@GetMapping("/")
	public String viewHomePage() {
		return "index";
	}
	
	
	// display list of products
	@GetMapping("/products")
	public String showProductManager(Model model) {
		model.addAttribute("listProducts", product_service.getAllProducts());
		
		return "product_manager";
	}
	
	
	// display add product form
	@GetMapping("/showNewProductForm")
	public String showNewProductForm(Model model) {
		// create model attribute to bind form data
		Product product = new Product();
		model.addAttribute("product", product);
		return "add_product";
	}
	
	
	// save product
	@PostMapping("/saveProduct")
	public String saveProduct(@ModelAttribute("product") Product product) {
		// save product to database
		product_service.saveProduct(product);
		return "redirect:/products";
	}
	
	
	@GetMapping("/showUpdateProduct/{id}")
	public String showUpdateProduct(@PathVariable(value="id") long id, Model model) {
		
		// get product from the service
		Product product = product_service.getProductByID(id);
		
		// set product as a model attribute to pre-populate the form
		model.addAttribute("product", product);
		return "update_product";
	}
	
	
	@GetMapping("/deleteProduct/{id}")
	public String deleteProduct(@PathVariable(value="id") long id, Model model) {
		
		// call delete product method
		this.product_service.deleteProductByID(id);
		return "redirect:/products";
	}

}

























