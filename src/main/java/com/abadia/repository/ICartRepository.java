package com.abadia.repository;

import org.springframework.data.repository.CrudRepository;

import com.abadia.entity.Cart;

public interface ICartRepository extends CrudRepository<Cart, String> {
	
	

}
