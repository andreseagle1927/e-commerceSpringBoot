package com.abadia.first.repository;

import org.springframework.data.repository.CrudRepository;

import com.abadia.first.entity.PurchaseHistory;

public interface IPurchaseHistoryRepository extends CrudRepository<PurchaseHistory, String> {
	
	

}
