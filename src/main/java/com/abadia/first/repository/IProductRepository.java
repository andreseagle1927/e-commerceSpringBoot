package com.abadia.first.repository;

import org.springframework.data.repository.CrudRepository;

import com.abadia.first.entity.Product;

public interface IProductRepository extends CrudRepository<Product, Integer> {
	
	

}
