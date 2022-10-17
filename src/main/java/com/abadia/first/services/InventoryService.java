package com.abadia.first.services;

import com.abadia.first.entity.Inventory;
import com.abadia.first.entity.Product;
import com.abadia.first.repository.IInvetoryRepository;
import org.springframework.beans.factory.annotation.Autowired;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

public class InventoryService {

    @Autowired
    IInvetoryRepository invetoryRepository;



    //THIS IF FOR TAKE ONE PRODUCT FROM THE STOCK
    public Product findProductByName(String nameProduct, String inventoryId) {
        List<Product> products = new ArrayList<>();
        Product theProduct = null;
        Optional<Inventory> invetory = invetoryRepository.findById(inventoryId);

        if (invetory.isPresent()) {
            products = invetory.get().getProductsList();
            for (int i = 0; i < products.size(); i++) {

                if (products.get(i).getName() == nameProduct) {
                    theProduct = products.get(i);

                }
            }
        }
        return theProduct;
    }


    // THIS FUNCTION IS FOR HELP US TO KNOW HOW MANY PRODUCTS OF "x" NAME THERE ARE IN STOCK
    public int countByName(String nameProduct, String inventoryId) {
        List<Product> products = new ArrayList<>();
        List<Product> theProductsFound = new ArrayList<>();
        Optional<Inventory> invetory = invetoryRepository.findById(inventoryId);


        if (invetory.isPresent()) {
            products = invetory.get().getProductsList();

            for (int i = 0; i < products.size(); i++) {

                if (products.get(i).getName() == nameProduct) {
                    theProductsFound.add(products.get(i));
                }
            }
        }
        return theProductsFound.size();
    }

    // RETURN AS LIST ALL THE PRODUCTS FROM THE INVENTORY, JUST FOR ADMINISTRATIVE USE
    public List<Product> getInvetory(String inventoryId){
        List<Product> products = new ArrayList<>();
        Optional<Inventory> invetory = invetoryRepository.findById(inventoryId);

        if (invetory.isPresent()){
            products = invetory.get().getProductsList();
        }

        return products;
    }

    public void save(Optional<Inventory> inventory){

        if (inventory.isPresent()){
            invetoryRepository.save(inventory.get());
        }

    }
    
    public Optional<Inventory> findInventoryByid(String ip){
        return invetoryRepository.findById(ip);
    }
}


