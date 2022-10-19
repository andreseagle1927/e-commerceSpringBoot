package com.abadia.first.services;

import com.abadia.first.entity.Inventory;
import com.abadia.first.entity.Product;
import com.abadia.first.repository.IInvetoryRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import java.util.Optional;

@Service
public class InventoryService {

    @Autowired
    IInvetoryRepository invetoryRepository;



    //THIS IF FOR TAKE ONE PRODUCT FROM THE STOCK
    public Product findProductByIdBase(Integer idProductBase) {

        Product theProduct = null;
        Iterable<Inventory> invetory = invetoryRepository.findAll();



        Iterator<Inventory> iterator = invetory.iterator();

        while(iterator.hasNext()){
            if(iterator.next().getProduct().getId() == idProductBase){
                theProduct = iterator.next().getProduct();
            }
        }

        return theProduct;
    }


    // THIS FUNCTION IS FOR HELP US TO KNOW HOW MANY PRODUCTS OF "x" NAME THERE ARE IN STOCK
    public int countByIdBase(Integer idProductBase) {
        int quantity = 0;
        Iterable<Inventory> invetory = invetoryRepository.findAll();



        Iterator<Inventory> iterator = invetory.iterator();

        while(iterator.hasNext()){
            Product theProduct = iterator.next().getProduct();
            if(theProduct.getId() == idProductBase){
                theProduct = iterator.next().getProduct();
                quantity = theProduct.getStock().size();
            }
        }

        return quantity;


    }

    // RETURN AS LIST ALL THE PRODUCTS FROM THE INVENTORY, JUST FOR ADMINISTRATIVE USE
    public List<Inventory> getInvetory(){
        List<Inventory> inventoryList = new ArrayList<>();


        Iterable<Inventory> invetory = invetoryRepository.findAll();

        Iterator<Inventory> iterator = invetory.iterator();

        while(iterator.hasNext()){
            inventoryList.add(iterator.next());
        }


        return inventoryList;
    }


}


