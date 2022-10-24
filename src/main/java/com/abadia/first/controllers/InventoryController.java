package com.abadia.first.controllers;

import com.abadia.first.entity.Inventory;
import com.abadia.first.entity.Product;
import com.abadia.first.repository.IInvetoryRepository;
import com.abadia.first.repository.IProductRepository;
import com.abadia.first.services.InventoryService;

import java.util.List;
import java.util.Optional;

import javax.servlet.http.HttpServletRequest;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/Inventory")

public class InventoryController {

    @Autowired
    InventoryService inventoryService;
    
    @Autowired
    IInvetoryRepository invetoryRepository;
    
    @Autowired
    IProductRepository productRepository;
    
    Product theProduct;
    
    

    @RequestMapping(value="/getProductInfo", method = RequestMethod.GET)
    public ResponseEntity<Integer>getProductInfo(@RequestParam(value = "id") Integer idBaseProduct){

        Optional<Product> product= productRepository.findById(idBaseProduct);
        
        if(product.isPresent()) {
        	theProduct = product.get();
        }
    	
    	
    	
        return new ResponseEntity(theProduct, HttpStatus.OK);
    }
    
    @RequestMapping(value="/takeProduct", method = RequestMethod.GET)
    public ResponseEntity<Inventory>takeProductOfInvetory(@RequestParam(value = "id") Integer idBaseProduct){

    	Inventory productExist = inventoryService.findProductByIdBase(idBaseProduct);
    	
        return new ResponseEntity(productExist, HttpStatus.OK);
    }
    
    @RequestMapping(value="/productsInStockid", method = RequestMethod.GET)
    public ResponseEntity<Integer> numberOfProductsInStockByID(@RequestParam(value = "id") Integer id, HttpServletRequest request){
    	Integer numberOfProducts =inventoryService.countByIdBase(id);
    	
    		
    	
    	
        // if the product was added to the cart, it will return that cart, else it will return an empty cart
        
        return new ResponseEntity(numberOfProducts, HttpStatus.OK);
    }

   
}
