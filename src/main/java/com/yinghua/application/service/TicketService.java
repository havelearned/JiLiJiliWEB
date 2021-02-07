package com.yinghua.application.service;

import com.yinghua.application.mapper.TicketMapper;
import com.yinghua.application.pojo.Ticket;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

/**
 * @ClassName TicketService
 * @Description TODO
 * @Author Luojiaju
 * @crete 2020-12-19-17:14-16
 * @Version 1.0
 */
@Service
public class TicketService {
    Logger logger = LoggerFactory.getLogger(getClass());
    @Autowired
    TicketMapper ticketMapper;

    //更具id查询购票者
    public Ticket  doQueryTicket(Integer id){
        logger.trace("TicketService.doQueryTicket 更具id查询购票者");
        Ticket ticket = ticketMapper.selectByPrimaryKey(id);
        return  ticket;
    }

    //查询所有的购票者
    public List<Ticket> doQueryTickets(){
        logger.trace("TicketService.doQueryTickets 查询所有的购票者");
        List<Ticket> tickets = ticketMapper.selectByPrimarys();
        return tickets;
    }

    //更具返回实际id
    public int doDeleteTicket(Integer id){
        logger.trace("TicketService.doDeleteTicket 更具返回实际id");
        int i = ticketMapper.deleteByPrimaryKey(id);
        return i;
    }

}
