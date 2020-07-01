package com.jpa.api.dao;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import com.jpa.api.entity.Product;

@Repository
public interface ProductRepositry extends JpaRepository<Product, Long> {

	Product findByName(String name);
	
	@Query(value = "select * from product where product_id=?1 and name=?2",  nativeQuery = true)
	Product findByIdAndName(Long productId, String name);
	
	@Query(value = "select * from product where name=:name",  nativeQuery = true)
	Product findByProductName(@Param("name")String name);
	
	@Transactional
	@Modifying
	@Query(nativeQuery = true, value = "update product set name=:name where product_id=:product_id")
	int updateProduct(@Param("name")long name, @Param("product_id")double product_id);
	

}
