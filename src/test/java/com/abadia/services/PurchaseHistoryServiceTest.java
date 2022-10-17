package com.abadia.services;

import com.abadia.entity.PurchaseHistory;
import com.abadia.repository.IPurchaseHistoryRepository;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.MockitoAnnotations;

import java.util.Arrays;

import static org.junit.jupiter.api.Assertions.*;
import static org.mockito.ArgumentMatchers.any;
import static org.mockito.Mockito.when;

class PurchaseHistoryServiceTest {

    @Mock
    IPurchaseHistoryRepository purchaseRepository;

    @InjectMocks
    PurchaseHistoryService purchaseHistoryService;

    PurchaseHistory purchaseHistory;

    @BeforeEach
    void setUp() {
        MockitoAnnotations.openMocks(this);

        purchaseHistory = new PurchaseHistory();
        purchaseHistory.setIp("001");
        purchaseHistory.setProductsName("Yogurt");
        purchaseHistory.setEmail("german");

    }

    @Test
    void getPurchaseHistory() {

        when(purchaseRepository.findAll()).thenReturn(Arrays.asList(purchaseHistory));
        assertNotNull(purchaseHistoryService.getPurchaseHistory());


    }

    @Test
    void save() {
        when(purchaseRepository.save(purchaseHistory)).thenReturn(purchaseHistory);
        assertNotNull(purchaseHistoryService.save(purchaseHistory));
    }
}