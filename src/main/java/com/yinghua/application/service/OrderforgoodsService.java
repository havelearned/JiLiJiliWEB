package com.yinghua.application.service;

import com.yinghua.application.mapper.OrderforgoodsMapper;
import com.yinghua.application.pojo.Orderforgoods;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * @ClassName Orderforgoods
 * @Description TODO
 * @Author Luojiaju
 * @crete 2020-12-17-11:33-07
 * @Version 1.0
 */
@Service
public class OrderforgoodsService {

    @Autowired
    OrderforgoodsMapper orderforgoods;
    Logger logger = LoggerFactory.getLogger(getClass());
    //查询所有订单
    public  List<Orderforgoods> doQueryOrders(){
        logger.trace("OrderforgoodsService.doQueryOrders 查询所有订单 ");
        List<Orderforgoods> orderforgoods = this.orderforgoods.selectOrders();
        return orderforgoods;
    }



}
