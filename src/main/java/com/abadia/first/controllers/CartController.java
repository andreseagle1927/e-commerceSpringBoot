package com.abadia.first.controllers;

import com.abadia.first.entity.Cart;
import com.abadia.first.entity.Inventory;
import com.abadia.first.especialsMethods.externalsClasses.HttpUtils;
import com.abadia.first.repository.IInvetoryRepository;
import com.abadia.first.services.CartService;
import com.abadia.first.services.InventoryService;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import java.util.ArrayList;
import java.util.List;

import javax.servlet.http.HttpServletRequest;

@RestController
public class CartController {
  
    
    @Autowired
    CartService cartService;
    
    @Autowired
    InventoryService inventoryService;
    
    IInvetoryRepository iInvetoryRepository;

    @RequestMapping(value="/addProduct", method = RequestMethod.GET)
    public ResponseEntity<Cart> addProduct(@RequestParam(value = "id") Integer id, HttpServletRequest request){
    	Inventory inventory;
    	Cart elcart;
        String ip = HttpUtils.getRequestIP(request);
        inventory = inventoryService.findProductByIdBase(id);
        
        if(inventory != null) {
        	//elcart = cartMethods.addProductToCart(inventory, ip);
        	
        	if(cartService.checkIfExist(ip)) {
        		elcart = cartService.getCartByIp(ip);
      
        	}else {
    			elcart = cartService.createCart(ip);
    			cartService.save(elcart);
    		
    			
    		}
        	
	        inventory.setCart(elcart);
	        inventoryService.save(inventory);
        
        }else {
        	elcart = new Cart();
		}
        
        // if the product was added to the cart, it will return that cart, else it will return an empty cart
        
        return new ResponseEntity(elcart, HttpStatus.OK);
    }

   
    
    @RequestMapping(value="/getPriceOfCart", method = RequestMethod.GET)
    public ResponseEntity<Integer> getPriceOfCart(@RequestParam(value = "id") Integer id, HttpServletRequest request){
    	String ip = HttpUtils.getRequestIP(request);
    	Integer total = 0;
    	Cart cart;
    	
    		cart = cartService.getCart(id);
    		
    		total += inventoryService.getCartPrice(cart.getId());
    		
    	
    	
        // if the product was added to the cart, it will return that cart, else it will return an empty cart
        
        return new ResponseEntity(total, HttpStatus.OK);
    }
    
    @RequestMapping(value="/CartByID", method = RequestMethod.GET)
    public ResponseEntity<List<Inventory>> geCart(@RequestParam(value = "id") Integer id, HttpServletRequest request){
    	String ip = HttpUtils.getRequestIP(request);
    	
    	List<Inventory> inventoryList = new ArrayList<Inventory>();
    	
    	inventoryList = inventoryService.getCartById(id);
    		
    	
    	
        // if the product was added to the cart, it will return that cart, else it will return an empty cart
        
        return new ResponseEntity(inventoryList, HttpStatus.OK);
    }
    
    
    
}
