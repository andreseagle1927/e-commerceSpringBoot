package com.abadia.first.controllers;

import com.abadia.first.entity.Cart;
import com.abadia.first.entity.Inventory;
import com.abadia.first.especialsMethods.CartMethods;
import com.abadia.first.especialsMethods.externalsClasses.HttpUtils;
import com.abadia.first.repository.IInvetoryRepository;
import com.abadia.first.services.InventoryService;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import javax.servlet.http.HttpServletRequest;

@RestController
public class CartController {
    @Autowired
    CartMethods cartMethods;
    
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
        	elcart = cartMethods.addProductToCart(inventory, ip);
	        inventory.setCart(elcart);
	        inventoryService.save(inventory);
        }else {
        	elcart = new Cart();
        	
		}
        
        
        
        
        return new ResponseEntity(elcart, HttpStatus.OK);
    }

    public void payCart(){}

    public void buyOne(){}

    public void productsOnCart(){}
}
