package com.abadia.especialsMethods;

import com.abadia.entity.Cart;
import com.abadia.entity.Inventory;
import com.abadia.entity.Product;
import com.abadia.services.CartService;
import com.abadia.services.InventoryService;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

public class CartMethods {

    CartService cartService;

    InventoryService inventoryService;

    String idInvetory = "001";

    Cart cart;

    Optional<Inventory> inventory;



    public boolean addProductToCart(String name, String ip){

        if (this.verificatorStock(name)){
            Product product = inventoryService.findProductByName(name,idInvetory);
            cart.setIp(ip);
            cart.getProductsList().add(product);
            return true;
        }
        else {
            return false;
        }
    }

    public float getPriceOfCart(String ip){
        Cart thecart = cartService.findId(ip);
        List<Product> listProducts = thecart.getProductsList();
        float price = 0;

        for (int i= 0; i < listProducts.size(); i++) {
                price = price + listProducts.get(i).getPrice();
        }
        return price;
    }

    public void buyOne(String productName, String email, String ip){


        if (this.verificatorStock(productName)){
            Product product = inventoryService.findProductByName(productName,idInvetory);
            List<Product> products = inventoryService.getInvetory(ip);
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
    }

    public List<Product> getAllProductsOnCart(String ip){
        inventory = inventoryService.findInventoryByid(idInvetory);
        cart = cartService.findId(ip);
        List<Product> products = new ArrayList<>();

        if (cart != null){
            products = cart.getProductsList();
        }

        return products;
    }

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
    }

    public String getNameProductsString(String ip){
        cart = cartService.findId(ip);
        List<Product> products = new ArrayList<>();

        if (cart != null){
            products = cart.getProductsList();
        }

        //AQUI IRA LA TRANSFORMACION DE ARRAY A STRING

        return "hola";

    }

}
