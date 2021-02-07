package com.yinghua.application.mapper;

import com.yinghua.application.pojo.Orderforgoods;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Map;

/**
 * @author Luojiaju
 * @description: 订单 功能接口
 * @return
 * @params
 * @data 2020/12/14 18:36
 **/
@Repository
public interface OrderforgoodsMapper {
    int insert(Orderforgoods record);

    Orderforgoods selectOrderByid(String oid);

    List<Orderforgoods> selectOrders();

    boolean deleteOrderById(String oid);

    int insertSelective(Orderforgoods record);

}