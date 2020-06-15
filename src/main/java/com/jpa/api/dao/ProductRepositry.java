package com.jpa.api.dao;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.jpa.api.entity.Product;

@Repository
public interface ProductRepositry extends JpaRepository<Product, Long> {

	Product findByName(String name);

}
