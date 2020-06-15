package com.jpa.api.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

import com.jpa.api.entity.Product;
import com.jpa.api.service.ProductService;

@RestController
@RequestMapping("/Product")
public class ProductController {

	@Autowired
	ProductService productService;

	@GetMapping("/get/{id}")
	public Product getProduct(@PathVariable long id) {
		return productService.getProductById(id);
	}

	@GetMapping("/get/list")
	public List<Product> getAllProducts() {
		return productService.getAllProducts();
	}

	@GetMapping("/getProduct/{name}")
	public Product getProductByName(@PathVariable String name) {
		return productService.getProductByName(name);
	}

	@PostMapping("/create")
	public @ResponseBody Product saveProduct(@RequestBody Product product) {
		return productService.saveProduct(product);
	}

	@PostMapping("/create/list")
	public @ResponseBody List<Product> saveProducts(@RequestBody List<Product> product) {
		return productService.saveProducts(product);
	}

	@DeleteMapping("/delete/{id}")
	public @ResponseBody String deeteProduct(@PathVariable long id) {
		return productService.deleteProduct(id);
	}

	@PutMapping("/update")
	public @ResponseBody Product deeteProduct(@RequestBody Product product) {
		return productService.updateProduct(product);
	}

}
