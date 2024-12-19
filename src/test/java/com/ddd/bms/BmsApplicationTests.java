package com.ddd.bms;

import com.ddd.service.AdminInfoService;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.util.DigestUtils;

@SpringBootTest
class BmsApplicationTests {
    @Autowired
    private AdminInfoService adminInfoService;

//    @Test
//    void contextLoads() {
//        List<BookTypeInfo> list = bookTypeInfoServie.list();
//        System.out.println(list.toString());
//
//    }
    @Test
    void contextLoads1() {
        String password = "123456";
        String s = DigestUtils.md5DigestAsHex(password.getBytes());
        System.out.println(s);
//        AdminInfo adminInfo = new AdminInfo();
//        String password = DigestUtils.md5DigestAsHex("root".getBytes());
//        adminInfo.setOperatorName("root");
//        adminInfo.setOperatorPass(password);
//        adminInfoService.save(adminInfo);

    }

}
