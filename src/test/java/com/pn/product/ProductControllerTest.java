package com.pn.product;

import com.pn.entity.Product;
import org.junit.jupiter.api.Test;
import org.springframework.boot.test.context.SpringBootTest;

@SpringBootTest
public class ProductControllerTest {
    @Test
    void addProductTest(){
        Product product = new Product();
        product.setBrandId(1);
        product.setStoreId(8);
        product.setProductName("测试商品1");
        product.setProductNum("CSSP1");
        product.setProductInvent(200);
        product.setTypeId(16);
        product.setTypeName("测试分类");

    }
    @Test
    void updateProductTest(){

    }
}
