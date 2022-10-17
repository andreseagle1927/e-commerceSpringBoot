package com.abadia.first.controllers;

import com.abadia.first.entity.Product;
import com.abadia.first.services.InventoryService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/Inventory")

public class InventoryController {

    @Autowired
    InventoryService inventoryService;

    String defaultInventoryID = "001";

    @RequestMapping(value="/getProductStock", method = RequestMethod.GET)
    public ResponseEntity<Integer>getProductStock(@RequestParam(value = "name") String name){

        int productsOnStock = inventoryService.countByName(name, defaultInventoryID);
        return new ResponseEntity(productsOnStock, HttpStatus.OK);
    }

    @RequestMapping(value="/getProductInfo", method = RequestMethod.GET)
    public ResponseEntity<Product>getProductInfo(@RequestParam(value = "name") String name){

        Product product= inventoryService.findProductByName(name, defaultInventoryID);
        return new ResponseEntity(product, HttpStatus.OK);
    }
}
