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

    Integer defaultInventoryID = 1;

    @RequestMapping(value="/getProductStock", method = RequestMethod.GET)
    public ResponseEntity<Integer>getProductStock(@RequestParam(value = "id") Integer idBaseProduct){

        int productsOnStock = inventoryService.countByIdBase(idBaseProduct);
        return new ResponseEntity(productsOnStock, HttpStatus.OK);
    }

    @RequestMapping(value="/getProductInfo", method = RequestMethod.GET)
    public ResponseEntity<Integer>getProductInfo(@RequestParam(value = "id") Integer idBaseProduct){

        Product product= inventoryService.findProductByIdBase(idBaseProduct);
        return new ResponseEntity(product, HttpStatus.OK);
    }
}
