package com.mphasis.Controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.Scope;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestController;

import com.mphasis.domain.Product;
import com.mphasis.service.ProductService;

@RestController(value = "productController")
@Scope("request")
public class ProductController {
	
	 @Value("${msg:Config Server is not working. Please check...}")
	 private String msg;
	 
	 @GetMapping("/msg")
	 public String getMsg() {
	     return this.msg;
	 }
	
	@Autowired
	ProductService productService;
	
	@GetMapping(value = "/products")
	public List<Product> getProducts(){
		return productService.getProducts();
	}
	
	@GetMapping(value = "/products/{id}")
	public Product getProductById(@PathVariable("id") Integer id) {
		return productService.getProductById(id);
	}
	
	@PostMapping(value= "/products")
	@ResponseStatus(code = HttpStatus.CREATED)
	public Product addProduct(@RequestBody Product product) {
		return productService.addProduct(product);
	}
	
	
	@PutMapping(value = "/products")
	@ResponseStatus(code = HttpStatus.OK)
	public Product updateProduct(Product product) {
		return productService.updateProduct(product);
	}
	
	@DeleteMapping(value = "/products/{id}")
	public void deleteProductById(Integer id) {
		productService.deleteProductById(id);
	}
	
	

}
