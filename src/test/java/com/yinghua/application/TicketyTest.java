package com.yinghua.application;


import com.yinghua.application.pojo.Ticket;
import com.yinghua.application.service.TicketService;
import org.junit.jupiter.api.Test;
import org.mybatis.spring.annotation.MapperScan;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

@SpringBootTest
@MapperScan("com.yinghua.application.mapper")
public class TicketyTest {

    @Autowired
    TicketService ticketService;

    @Test
    public void Test01(){
        Ticket aBoolean = ticketService.doQueryTicketByPhone("177545726486");
        if(aBoolean==null){
            System.out.println("不存在需要注册");
        }else{

            System.out.println(aBoolean.toString());
        }
    }
}
