package com.yinghua.application.mapper;

import com.yinghua.application.pojo.Ticket;
import org.springframework.stereotype.Repository;

import java.util.List;

/**
 * @author Luojiaju
 * @description: 购票者 功能接口
 * @return
 * @params
 * @data 2020/12/14 18:37
 **/
@Repository
public interface TicketMapper {

    Ticket QueryTicketByPhone(String ticketPhone);

    int deleteByPrimaryKey(Integer tId);

    int insert(Ticket record);

    int insertSelective(Ticket record);

    Ticket selectByPrimaryKey(Integer tId);

    List<Ticket> selectByPrimarys();

    int updateByPrimaryKeySelective(Ticket record);

    int updateByPrimaryKey(Ticket record);
}