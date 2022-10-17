package com.abadia.first.controllers;

import com.abadia.first.especialsMethods.CartMethods;
import com.abadia.first.especialsMethods.externalsClasses.HttpUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import javax.servlet.http.HttpServletRequest;

@RestController
public class CartController {
    @Autowired
    CartMethods cartMethods;

    @RequestMapping(value="/addProduct", method = RequestMethod.GET)
    public void addProduct(@RequestParam(value = "name") String nameProduct, HttpServletRequest request){
        String ip = HttpUtils.getRequestIP(request);
        cartMethods.addProductToCart("amigo", "hola");
    }

    public void payCart(){}

    public void buyOne(){}

    public void productsOnCart(){}
}
