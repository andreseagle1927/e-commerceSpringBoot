package com.abadia.repository;

import org.springframework.data.repository.CrudRepository;


import com.abadia.entity.Inventory;

public interface IInvetoryRepository extends CrudRepository<Inventory, String> {
	
	

}
