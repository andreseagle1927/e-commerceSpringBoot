package com.abadia.services;

import com.abadia.entity.ActivityRegister;
import com.abadia.entity.Cart;
import com.abadia.entity.Product;
import com.abadia.repository.ICartRepository;
import com.abadia.repository.IProductRepository;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.MockitoAnnotations;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Optional;

import static org.junit.jupiter.api.Assertions.*;
import static org.mockito.ArgumentMatchers.anyString;
import static org.mockito.Mockito.*;

class CartServiceTest {

    @Mock
    ICartRepository cartRepository;

    @Mock
    IProductRepository productRepository;

    @InjectMocks
    CartService cartService;

    Cart cart;

    Product product;
    Product product2;
    Product product3;

    List<Product> arrayProducts= new ArrayList<>();

    @BeforeEach
    void setUp() {
        MockitoAnnotations.openMocks(this);

        product = new Product();
        //product.setIp(12L);
        product.setName("lola");
        //change price to long
        product.setPrice(223);
        product.setType("t-shirt");

        product2 = new Product();
        product2.setId(18);
        product2.setName("leon");
        //change price to long
        product2.setPrice(2223);
        product2.setType("jean");

        product3 = new Product();
        product3.setId(12);
        product3.setName("adidas");
        //change price to long
        product3.setPrice(4000);
        product3.setType("shoes");

        arrayProducts.add(product);
        arrayProducts.add(product2);
        arrayProducts.add(product3);



        cart = new Cart();
        cart.setIp("001");
        cart.setProductsList(arrayProducts);

    }



    @Test
    void deleteById() {

    }

    @Test
    void save() {
        when(cartRepository.save(cart)).thenReturn(cart);
        assertNotNull(cartService.save(cart));
    }

    @Test
    void findId() {
        when(cartRepository.findById(anyString())).thenReturn(Optional.ofNullable(cart));

        Cart local = cartService.findId("001");

        Product objeto = local.getProductsList().get(0);
        System.out.println(objeto.getName());
        assertNotNull(cartService.findId("001"));
    }
}