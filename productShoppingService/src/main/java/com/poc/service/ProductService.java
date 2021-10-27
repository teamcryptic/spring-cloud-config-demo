package com.poc.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.poc.domain.Product;
import com.poc.repository.ProductRepository;

@Service(value = "productService")
public class ProductService {
	
	@Autowired
	ProductRepository productRepository;
	
	public List<Product> getProducts(){
		return productRepository.findAll();
	}
	
	public Product getProductById(Integer id) {
		return productRepository.findById(id).get();
	}
	
	public Product addProduct(Product product) {
		return productRepository.save(product);
	}
	
	public void deleteProductById(Integer id) {
		productRepository.deleteById(id);
	}
	
	public Product updateProduct(Product product) {
		return productRepository.save(product);
	}
}
