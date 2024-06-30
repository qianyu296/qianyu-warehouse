package com.pn;

import com.pn.mapper.SupplierMapper;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import java.util.List;

@SpringBootTest
class WarehouseApplicationTests {
    @Autowired
    private SupplierMapper supplierMapper;
    @Test
    void contextLoads() {
    }
    @Test
    void testSupplierDelete(){
        Integer count = supplierMapper.selectSupplierIsBuy(1);
        System.out.println(count);
    }
}
