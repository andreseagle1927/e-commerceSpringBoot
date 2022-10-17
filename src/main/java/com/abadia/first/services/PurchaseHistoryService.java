package com.abadia.first.services;




import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.abadia.first.entity.PurchaseHistory;
import com.abadia.first.repository.IPurchaseHistoryRepository;

import java.util.List;


@Service
public class PurchaseHistoryService {
	
	
	@Autowired
	private IPurchaseHistoryRepository purchaseHistory;
	
	public List<PurchaseHistory> getPurchaseHistory(){
		return (List<PurchaseHistory>) purchaseHistory.findAll();
	}


	
	public PurchaseHistory save(PurchaseHistory purchase) {
		return purchaseHistory.save(purchase);


	}
	
	
}
