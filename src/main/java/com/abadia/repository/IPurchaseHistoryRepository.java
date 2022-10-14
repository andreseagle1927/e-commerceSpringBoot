package com.abadia.repository;

import org.springframework.data.repository.CrudRepository;

import com.abadia.entity.PurchaseHistory;

public interface IPurchaseHistoryRepository extends CrudRepository<PurchaseHistory, String> {
	
	

}
