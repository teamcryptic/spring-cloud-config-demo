package com.poc.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.poc.domain.Product;

@Repository(value = "productRepository")
public interface ProductRepository extends JpaRepository<Product, Integer>{
	
}


