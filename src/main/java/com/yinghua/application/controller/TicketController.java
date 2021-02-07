package com.yinghua.application.controller;

import com.yinghua.application.pojo.Orderforgoods;
import com.yinghua.application.pojo.Ticket;
import com.yinghua.application.pojo.TicketAndOrderings;
import com.yinghua.application.service.OrderforgoodsService;
import com.yinghua.application.service.TicketService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;

import java.lang.reflect.Array;
import java.util.ArrayList;
import java.util.List;

/**
 * @ClassName TicketController
 * @Description TODO
 * @Author Luojiaju
 * @crete 2020-12-19-17:13-48
 * @Version 1.0
 */

@Controller
public class TicketController {
    TicketAndOrderings tao;
    List<TicketAndOrderings> lt;
    @Autowired
    TicketService ticketService;

    @Autowired
    OrderforgoodsService orderforgoodsService;

    /**
     * @return java.lang.String
     * @description:doUserOrder 购票者订单展示列表 需要 购票者信息，订单信息
     * @params [model]
     * @data 2020/12/24 15:39
     * @author Luojiaju
     **/

    @GetMapping("/toUserOrder")
    public String doUserOrder(Model model) {
        System.out.println("TicketController.doUserOrder");
        List<Orderforgoods> orderforgoods = orderforgoodsService.doQueryOrders();
        if (!orderforgoods.isEmpty()) {
            lt = new ArrayList<>();
            for (int i = 0; i < orderforgoods.size(); i++) {
                tao = new TicketAndOrderings();
                tao.setUsername(orderforgoods.get(i).getoTnickname());
                tao.setUserPhone(orderforgoods.get(i).getoTphone());
                tao.setUserCard(orderforgoods.get(i).getoTcard());
                tao.setUserOrder(orderforgoods.get(i).getoBookingdate());
                lt.add(tao);
            }
        }

        if (!lt.isEmpty()) {
            model.addAttribute("lts", lt);
        }

        return "userorder/orders";
    }
}
