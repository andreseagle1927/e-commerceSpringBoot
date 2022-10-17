package com.abadia.especialsMethods;

import com.abadia.first.especialsMethods.CartMethods;
import com.abadia.first.services.InventoryService;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.MockitoAnnotations;

import static org.junit.jupiter.api.Assertions.*;
import static org.mockito.ArgumentMatchers.anyString;
import static org.mockito.Mockito.when;

class CartMethodsTest {

    @Mock
    InventoryService inventoryService;

    @InjectMocks
    CartMethods cartMethods;


    @BeforeEach
    void setUp() {
        MockitoAnnotations.openMocks(this);
    }

    @Test
    void verificatorStock() {
        //when(inventoryService.countByName(anyString(), anyString())).thenReturn(2);
        //assertEquals(cartMethods.verificatorStock("llo"), true);

    }
}