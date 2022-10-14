package com.abadia.services;




import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.abadia.entity.PurchaseHistory;
import com.abadia.repository.IPurchaseHistoryRepository;


@Service
public class PurchaseHistoryService {
	
	
	@Autowired
	private IPurchaseHistoryRepository purchaseHistory;
	
	

	
	public void save(PurchaseHistory purchase) {
		purchaseHistory.save(purchase);
		
	}
	
	
}
