package com.abadia.first.especialsMethods;

import com.abadia.first.entity.Cart;
import com.abadia.first.entity.Inventory;
import com.abadia.first.entity.Product;
import com.abadia.first.repository.ICartRepository;
import com.abadia.first.services.CartService;
import com.abadia.first.services.InventoryService;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class CartMethods {

	@Autowired
    CartService cartService;

	@Autowired
    InventoryService inventoryService;

    Integer idInvetory = 1;

    

    
    Optional<Inventory> inventory;
    
    ICartRepository cartRepository;



    public Cart addProductToCart(Inventory product, String ip){
    	Cart cart = null;
    	
    	if(cartService.checkIfExist(ip)) {
    		cart = cartService.getCartByIp(ip);
  
    	}else {
			cart = cartService.createCart(ip);
			cartService.save(cart);
		
			
		}
    	
    	return cart;
    		
    	
    	
    }
    
  
    

}
