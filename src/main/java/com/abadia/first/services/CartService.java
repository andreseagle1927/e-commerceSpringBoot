package com.abadia.first.services;

import com.abadia.first.entity.Cart;
import com.abadia.first.entity.Product;
import com.abadia.first.repository.ICartRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

@Service
public class CartService {
    @Autowired
    ICartRepository cart;



    public Cart findId(String id){
        Cart thecart = null;
        Optional<Cart> prueba = cart.findById(id);

        if(prueba.isPresent()){
            thecart = prueba.get();
        }

        return thecart;

    }

    public void deleteById(String id){

        cart.deleteById(id);

    }

    public Cart save(Cart thecart){
        return cart.save(thecart);
    }

    public List<Product> getCart(String inventoryId){
        List<Product> products = new ArrayList<>();
        Optional<Cart> thecart = cart.findById(inventoryId) ;

        if (thecart.isPresent()){
            products = thecart.get().getProductsList();
        }

        return products;
    }
}
