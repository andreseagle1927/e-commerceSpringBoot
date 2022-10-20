package com.abadia.first.especialsMethods;

import com.abadia.first.entity.Cart;
import com.abadia.first.entity.Inventory;
import com.abadia.first.entity.Product;
import com.abadia.first.repository.ICartRepository;
import com.abadia.first.services.CartService;
import com.abadia.first.services.InventoryService;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class CartMethods {

	@Autowired
    CartService cartService;

	@Autowired
    InventoryService inventoryService;

    Integer idInvetory = 1;

    

    
    Optional<Inventory> inventory;
    
    ICartRepository cartRepository;



    public Cart addProductToCart(Inventory product, String ip){
    	Cart cart = null;
    	
    	if(cartService.checkIfExist(ip)) {
    		cart = cartService.getCartByIp(ip);
  
    	}else {
			cart = cartService.createCart(ip);
			cartService.save(cart);
		
			
		}
    	
    	return cart;
    		
    	
    	
    }

    /*public float getPriceOfCart(String ip){
        Cart thecart = cartService.findId(ip);
        List<Product> listProducts = thecart.getProductsList();
        float price = 0;

        for (int i= 0; i < listProducts.size(); i++) {
                price = price + listProducts.get(i).getPrice();
        }
        return price;
    }*/

    /*
    public void buyOne(String productName, String email, String ip){


        if (this.verificatorStock(productName)){
            Product product = inventoryService.findProductByName(productName,idInvetory);
            List<Product> products = inventoryService.getInvetory(idInvetory);
            products.remove(product);

            inventory = inventoryService.findInventoryByid(idInvetory);
            inventory.get().setProductsList(products);

            inventoryService.save(inventory);

        }
    }

    public boolean verificatorStock(String productName){
        int producstOnStock = inventoryService.countByName(productName, idInvetory) ;

        if (producstOnStock > 0){
            return true;
        }
        return false;
    } */

    /*
    public List<Product> getAllProductsOnCart(String ip){
        inventory = inventoryService.findInventoryByid(idInvetory);
        cart = cartService.findId(ip);
        List<Product> products = new ArrayList<>();

        if (cart != null){
            products = cart.getProductsList();
        }

        return products;
    }*/

    /*
    public void RemoveProductsToBuy(String ip){
        inventory = inventoryService.findInventoryByid(idInvetory);
        List<Product> cartProducts = cartService.getCart(ip);

        if (inventory.isPresent()){
            List<Product> products = inventory.get().getProductsList();

            for (int i= 0; i < cartProducts.size(); i++) {
                    products.remove(cartProducts.get(i));

            }
            inventory.get().setProductsList(products);
            inventoryService.save(inventory);

        }
    } */

    /*public String getNameProductsString(String ip){
        cart = cartService.findId(ip);
        List<Product> products = new ArrayList<>();

        if (cart != null){
            products = cart.getProductsList();
        }

        //AQUI IRA LA TRANSFORMACION DE ARRAY A STRING

        return "hola";

    }*/


}
