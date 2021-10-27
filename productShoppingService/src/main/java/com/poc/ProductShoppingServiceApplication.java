package com.poc;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.core.env.Environment;

import com.poc.domain.Product;
import com.poc.repository.ProductRepository;

@SpringBootApplication
public class ProductShoppingServiceApplication implements CommandLineRunner{

	public static void main(String[] args) {
		SpringApplication.run(ProductShoppingServiceApplication.class, args);
	}
	
	 @Autowired
	 public void setEnv(Environment e){
        System.out.println(e.getProperty("msg"));
	  }
	 
	@Autowired
	@Qualifier(value = "productRepository")
	private ProductRepository productRepository;

	@Override
	public void run(String... args) throws Exception {
		productRepository.save(new Product(null, "TV" , "Electronics" , 70000.0));
		productRepository.save(new Product(null, "Wardrobe" , "Furniture" , 20000.0));
		productRepository.save(new Product(null, "Microwave" , "Electronics" , 30000.0));
		productRepository.save(new Product(null, "Jacket" , "Fashion" , 5000.0));
	}

}
