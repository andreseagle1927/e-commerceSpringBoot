package com.abadia.first.services;

import com.abadia.first.entity.Cart;
import com.abadia.first.entity.Inventory;
import com.abadia.first.entity.Product;
import com.abadia.first.repository.ICartRepository;

import net.bytebuddy.asm.Advice.Return;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import java.util.Optional;

@Service
public class CartService {
    @Autowired
    ICartRepository cart;

    

    public void deleteCart(Cart thecart){
        cart.delete(thecart);

    }

    public Cart save(Cart thecart){
        return cart.save(thecart);
    }
    
    public Cart createCart(String ip) {
		Cart cart = new Cart();
		cart.setId(1);
		cart.setIp(ip);
		
		return cart;
		
	}
    
    public boolean checkIfExist(String ip) {
    	
    	Boolean flag = false;
    	Cart thecart = null;
    	
    	List<Cart> productList = new ArrayList<Cart>();
    	Iterable<Cart> allCarts = cart.findAll();
    	
    	Iterator<Cart> iterator = allCarts.iterator();
    	
    	while(iterator.hasNext()){
        	productList.add(iterator.next());
   
        }
    	
    	for(int i = 0; i < productList.size(); i++ ) {
        	if (productList.get(i).getIp() == ip) {
        		thecart = productList.get(i);
        		flag = true;
			}
        }
    	
    	// RETORNARA TRUE SI EXSITE, O RETORNARA FALSE SI NO EXISTE
    	// POR AHORA DEVUELVE UN CART, PERO SOLO PARA PRUEBA
    	//	return thecart;
    	
    	return flag;
    	
	}
    
    public Cart getCart(Integer id) {
    	Cart foundedCart = null;
    	Optional<Cart> thecart = cart.findById(id);
    	
    	if(thecart.isPresent()) {
    		foundedCart = thecart.get();
    	}
    	
    	return foundedCart;
	}
    
    public Cart getCartByIp(String ip) {
    	Cart thecart = null;
    	
    	List<Cart> productList = new ArrayList<Cart>();
    	Iterable<Cart> allCarts = cart.findAll();
    	
    	Iterator<Cart> iterator = allCarts.iterator();
    	
    	while(iterator.hasNext()){
        	productList.add(iterator.next());
   
        }
    	
    	for(int i = 0; i < productList.size(); i++ ) {
        	if (productList.get(i).getIp() == ip) {
        		thecart = productList.get(i);
			}
        }
    	
    
    	return thecart;	
    	
	}
    
   
    
    

   
}
