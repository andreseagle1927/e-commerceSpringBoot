package com.abadia.first.controllers;

import com.abadia.first.especialsMethods.PurchaseHistoryMethods;
import com.abadia.first.especialsMethods.externalsClasses.HttpUtils;

import javax.servlet.http.HttpServletRequest;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class PurchaseHistoryController {
    @Autowired
    PurchaseHistoryMethods purchaseHistoryMethods;

    @RequestMapping(value="/recordPurchase", method = RequestMethod.GET)
    public ResponseEntity<String> recordRegister(@RequestParam(value = "name") String nameProduct, HttpServletRequest request){
        String ip = HttpUtils.getRequestIP(request);
        
        purchaseHistoryMethods.recordPurchase(ip, "danielgomelo@gmail.com", nameProduct);

        return new ResponseEntity(ip, HttpStatus.OK);
    }

}
