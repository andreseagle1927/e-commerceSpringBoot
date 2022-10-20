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
    public Inventory findProductByIdBase(Integer idProductBase) {

    	Inventory Inventory = null;
        Product theProduct = null;
        List<Product> productList = new ArrayList<Product>();
        List<Inventory> theinventory = new ArrayList<Inventory>();
        Iterable<Inventory> invetory = invetoryRepository.findAll();



        Iterator<Inventory> iterator = invetory.iterator();

        while(iterator.hasNext()){
        	theinventory.add(iterator.next());
           
        }
        
        for(int i = 0; i < theinventory.size(); i++ ) {
        	if (theinventory.get(i).getProduct().getId() == idProductBase && theinventory.get(i).getCart().getId() == 0) {
        		Inventory = theinventory.get(i);
        		
			}
        }

        return Inventory;
    }


    // THIS FUNCTION IS FOR HELP US TO KNOW HOW MANY PRODUCTS OF "x" NAME THERE ARE IN STOCK
    public int countByIdBase(Integer idProductBase) {
        
    	int contador = 0;
    	
        
        List<Integer> productList = new ArrayList<Integer>();
        Iterable<Inventory> invetory = invetoryRepository.findAll();
       



        Iterator<Inventory> iterator = invetory.iterator();
        
        

        while(iterator.hasNext()){
        	productList.add(iterator.next().getProduct().getId());
        	
        }
        
        for(int i = 0; i < productList.size(); i++ ) {
        	if (productList.get(i) == idProductBase) {
        		contador++;
			}
        }
        
        

        return contador;


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
    
    public void deleteInventory(Inventory inventory) {
		invetoryRepository.delete(inventory);
	}
    
    public void save(Inventory inventory) {
		invetoryRepository.save(inventory);
	}


}


