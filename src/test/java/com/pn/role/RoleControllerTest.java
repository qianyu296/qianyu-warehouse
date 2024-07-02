package com.pn.role;

import com.pn.controller.RoleController;
import com.pn.entity.Result;
import com.pn.entity.Role;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

@SpringBootTest
public class RoleControllerTest {
    @Autowired
    private RoleController roleController;
    String token = "eyJ0eXAiOiJKV1QiLCJhbGciOiJIUzI1NiJ9.eyJDTEFJTV9OQU1FX1VTRVJDT0RFIjoiYWRtaW4iLCJDTEFJTV9OQU1FX1VTRVJJRCI6MSwiQ0xBSU1fTkFNRV9VU0VSTkFNRSI6Iui2hee6p-euoeeQhuWRmCIsImV4cCI6MTcxOTg1NDM5MiwiaWF0IjoxNzE5ODQ3MTkyfQ.v-GgRDrN0BRSH2gNExa-FGB8U0wYxIAhQj71V_Pfzfg";
    @Test
    void testAddRole(){
        Role role = new Role();
        role.setRoleName("肖欢");
        role.setRoleCode("xiaohuan");
        role.setRoleDesc("肖欢大佬");
        Result result = roleController.addRole(role, token);
        System.out.println(result);
    }
}
