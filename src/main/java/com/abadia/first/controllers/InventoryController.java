package com.abadia.first.controllers;

import com.abadia.first.entity.Inventory;
import com.abadia.first.entity.Product;
import com.abadia.first.repository.IInvetoryRepository;
import com.abadia.first.repository.IProductRepository;
import com.abadia.first.services.InventoryService;

import java.util.List;
import java.util.Optional;

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
    
    

    Integer defaultInventoryID = 1;

    @RequestMapping(value="/getProductStock", method = RequestMethod.GET)
    public ResponseEntity<Integer>getProductStock(@RequestParam(value = "id") Integer idBaseProduct){

        int productsOnStock = inventoryService.countByIdBase(idBaseProduct);
    	
        return new ResponseEntity(productsOnStock, HttpStatus.OK);
    }

    @RequestMapping(value="/getProductInfo", method = RequestMethod.GET)
    public ResponseEntity<Integer>getProductInfo(@RequestParam(value = "id") Integer idBaseProduct){

        Optional<Product> product= productRepository.findById(idBaseProduct);
        
        if(product.isPresent()) {
        	theProduct = product.get();
        }
    	
    	
    	
        return new ResponseEntity(theProduct, HttpStatus.OK);
    }
    
    @RequestMapping(value="/takeProduct", method = RequestMethod.GET)
    public ResponseEntity<Inventory>takeProductOfInvetoryAndDeleteIt(@RequestParam(value = "id") Integer idBaseProduct){

    	Inventory h= inventoryService.findProductByIdBase(idBaseProduct);
    	
        return new ResponseEntity(h, HttpStatus.OK);
    }
   
}
