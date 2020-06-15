package com.jpa.api.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.jpa.api.dao.ProductRepositry;
import com.jpa.api.entity.Product;

@Service
public class ProductService {

	@Autowired
	ProductRepositry productRepositry;

	public Product saveProduct(Product product) {
		return productRepositry.save(product);
	}

	public List<Product> saveProducts(List<Product> produsts) {
		return productRepositry.saveAll(produsts);
	}

	public List<Product> getAllProducts() {
		return productRepositry.findAll();
	}

	public Product getProductById(long id) {
		return productRepositry.findById(id).orElse(null);
	}

	public Product getProductByName(String name) {
		return productRepositry.findByName(name);
	}

	public String deleteProduct(long id) {
		productRepositry.deleteById(id);
		return "Product deleted successfully!!" + id;
	}

	public Product updateProduct(Product product) {
		Product existingprod = productRepositry.findById(product.getId()).orElse(null);
		existingprod.setName(product.getName());
		existingprod.setPrice(product.getPrice());
		existingprod.setQuantity(product.getQuantity());
		return productRepositry.save(existingprod);
	}
}
