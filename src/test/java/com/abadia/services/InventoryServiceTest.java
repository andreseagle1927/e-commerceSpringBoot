package com.abadia.services;

import com.abadia.entity.Inventory;
import com.abadia.entity.Product;
import com.abadia.repository.IInvetoryRepository;
import com.abadia.repository.IProductRepository;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.MockitoAnnotations;
import org.springframework.beans.factory.annotation.Autowired;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

import static org.junit.jupiter.api.Assertions.*;
import static org.mockito.ArgumentMatchers.anyString;
import static org.mockito.Mockito.when;

class InventoryServiceTest {

    @Mock
    IInvetoryRepository invetoryRepository;

    @Mock
    IProductRepository productRepository;

    @InjectMocks
    InventoryService inventoryService;

    @Autowired
    Inventory inventory;

    Product product;
    Product product2;
    Product product3;

    Product product4;

    List<Product> arrayProducts= new ArrayList<>();

    @BeforeEach
    void setUp() {
        MockitoAnnotations.openMocks(this);

        product = new Product();
        //product.setId(12L);
        product.setName("lola");
        //change price to long
        product.setPrice(112);
        product.setType("t-shirt");

        product2 = new Product();
        product2.setId(18);
        product2.setName("leon");
        //change price to long
        product2.setPrice(990);
        product2.setType("jean");

        product3 = new Product();
        product3.setId(12);
        product3.setName("adidas");
        //change price to long
        product3.setPrice(332);
        product3.setType("shoes");

        product4 = new Product();
        product4.setId(19);
        product4.setName("adidas");
        //change price to long
        product4.setPrice(1123);
        product4.setType("shoes");

        arrayProducts.add(product);
        arrayProducts.add(product2);
        arrayProducts.add(product3);
        arrayProducts.add(product4);


        inventory = new Inventory();

        inventory.setProductsList(arrayProducts);

    }

    @Test
    void findProductByName() {
        when(invetoryRepository.findById(anyString())).thenReturn(Optional.ofNullable(inventory));
        assertNotNull(inventoryService.findProductByName("adidas","001"));

        //SHOW IN CONSOLE THE FOUND PRODUCT ID
        Product prueba = inventoryService.findProductByName("adidas", "001");
        System.out.println(prueba.getId());

    }

    @Test
    void countByName() {
        when(invetoryRepository.findById(anyString())).thenReturn(Optional.ofNullable(inventory));
        assertNotNull(inventoryService.countByName("adidas","001"));

        //SHOW IN CONSOLE THE FOUND PRODUCT ID
        int prueba = inventoryService.countByName("adidas", "001");
        System.out.println(prueba);
    }

    @Test
    void getInvetory() {
        when(invetoryRepository.findById(anyString())).thenReturn(Optional.ofNullable(inventory));
        assertNotNull(inventoryService.getInvetory("001"));

        //SHOW IN CONSOLE THE FOUND PRODUCT ID
        List<Product> prueba = inventoryService.getInvetory("001");
        System.out.println(prueba.get(0).getId());
    }




}