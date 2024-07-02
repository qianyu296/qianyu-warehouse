package com.pn.user;

import com.pn.controller.UserController;
import com.pn.dto.AssignRoleDto;
import com.pn.entity.Result;
import com.pn.entity.User;
import com.pn.page.Page;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

@SpringBootTest
public class UserControllerTest {
    @Autowired
    UserController userController;
    String token = "eyJ0eXAiOiJKV1QiLCJhbGciOiJIUzI1NiJ9.eyJDTEFJTV9OQU1FX1VTRVJDT0RFIjoiYWRtaW4iLCJDTEFJTV9OQU1FX1VTRVJJRCI6MSwiQ0xBSU1fTkFNRV9VU0VSTkFNRSI6Iui2hee6p-euoeeQhuWRmCIsImV4cCI6MTcxOTg1NDM5MiwiaWF0IjoxNzE5ODQ3MTkyfQ.v-GgRDrN0BRSH2gNExa-FGB8U0wYxIAhQj71V_Pfzfg";
    @Test
    void testAddUser(){
        User user = new User();
        user.setUserName("测试张三");
        user.setUserPwd("123456789");
        user.setUserCode("zhangsan");
        Date date = new Date();
        user.setCreateTime(date);
        Result result = userController.addUser(user, token);
        System.out.println(result);
    }
    @Test
    void testAuthList(){
        Result result = userController.authList(token);
        System.out.println(result);
    }
    @Test
    void testUserListPage(){
        Page page = new Page();
        page.setPageSize(5);
        page.setPageNum(1);
        page.setTotalNum(0);
        User user = new User();
        Result result = userController.userListPage(page, user);
        System.out.println(result);
    }

    @Test
    void testUpdateState(){
        User user = new User();
        user.setUserId(36);
        user.setUserState("1");
        Date date = new Date();
        user.setCreateTime(date);
        Result result = userController.updateUserState(user,token);
        System.out.println(result);
    }
    @Test
    void testAssignRole(){
        AssignRoleDto assignRoleDto = new AssignRoleDto();
        // assignRoleDto.setUserId(20);
        List<String> list = new ArrayList<>();
        list.add("测试");
        assignRoleDto.setRoleCheckList(list);
        Result result = userController.assignRole(assignRoleDto);
        System.out.println(result);
    }
}
