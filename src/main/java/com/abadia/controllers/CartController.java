package com.abadia.controllers;

import com.abadia.especialsMethods.CartMethods;
import com.abadia.especialsMethods.externalsClasses.HttpUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;

import javax.servlet.http.HttpServletRequest;

public class CartController {
    @Autowired
    CartMethods cartMethods;

    @RequestMapping(value="/addProduct", method = RequestMethod.GET)
    public void addProduct(@RequestParam String nameProduct, HttpServletRequest request){
        String ip = HttpUtils.getRequestIP(request);
        cartMethods.addProductToCart(nameProduct, ip);
    }

    public void payCart(){}

    public void buyOne(){}

    public void productsOnCart(){}
}
