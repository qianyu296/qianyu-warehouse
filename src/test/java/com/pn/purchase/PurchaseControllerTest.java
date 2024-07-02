package com.pn.purchase;

import com.pn.controller.PurchaseController;
import com.pn.dto.PurchaseAddDTO;
import com.pn.entity.Result;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

@SpringBootTest
public class PurchaseControllerTest {
    @Autowired
    private PurchaseController purchaseController;

    @Test
    void testAddPurchase(){
        PurchaseAddDTO purchase = new PurchaseAddDTO();
        purchase.setBuyNum(100);
        purchase.setBuyUser("李四");
        purchase.setProductId(1);
        purchase.setStoreId(1);
        purchase.setFactBuyNum(100);
        purchase.setSupplierId(4);
        purchase.setPhone("17574603628");
        Result result = purchaseController.addPurchase(purchase);
        System.out.println(result);
    }
}
