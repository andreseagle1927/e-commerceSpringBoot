package com.abadia.first.especialsMethods;

import com.abadia.first.entity.PurchaseHistory;
import com.abadia.first.services.InventoryService;
import com.abadia.first.services.PurchaseHistoryService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.mail.javamail.JavaMailSender;
import org.springframework.stereotype.Service;

@Service
public class PurchaseHistoryMethods {
    CartMethods cart;
    InventoryService inventoryService;

    @Autowired
    JavaMailSender mailSender;

    @Autowired
    PurchaseHistoryService purchaseHistoryService;

    public void recordPurchase(String ip, String correo, String productsName){
        PurchaseHistory purchase = new PurchaseHistory();
        purchase.setIp(ip);
        purchase.setEmail(correo);
        purchase.setProductsName(productsName);

        purchaseHistoryService.save(purchase);
    }

    public void sendEmail(String emailAddress, String content){

    }

}
