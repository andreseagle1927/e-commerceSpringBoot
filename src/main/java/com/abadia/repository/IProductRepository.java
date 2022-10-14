package com.abadia.repository;

import org.springframework.data.repository.CrudRepository;

import com.abadia.entity.Product;

public interface IProductRepository extends CrudRepository<Product, String> {
	
	

}
