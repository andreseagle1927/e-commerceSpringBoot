package com.abadia.first.repository;

import org.springframework.data.repository.CrudRepository;

import com.abadia.first.entity.Cart;

public interface ICartRepository extends CrudRepository<Cart, String> {
	
	

}
