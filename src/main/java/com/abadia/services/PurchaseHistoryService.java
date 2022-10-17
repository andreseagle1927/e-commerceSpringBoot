package com.abadia.services;




import com.abadia.entity.ActivityRegister;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.abadia.entity.PurchaseHistory;
import com.abadia.repository.IPurchaseHistoryRepository;

import java.util.ArrayList;
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
