package com.abadia.first.repository;

import org.springframework.data.repository.CrudRepository;


import com.abadia.first.entity.Inventory;

public interface IInvetoryRepository extends CrudRepository<Inventory, Integer> {
	
	

}
