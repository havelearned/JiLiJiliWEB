package com.yinghua.application.controller.model;


import com.github.pagehelper.PageHelper;
import com.yinghua.application.mapper.MoviesMapper;
import com.yinghua.application.mapper.PhotoMapper;
import com.yinghua.application.pojo.Movies;
import com.yinghua.application.pojo.Ticket;
import com.yinghua.application.service.CinemaService;
import com.yinghua.application.service.MovieService;
import com.yinghua.application.service.OrderforgoodsService;
import com.yinghua.application.service.TicketService;
import com.yinghua.application.util.EmailUtil;
import io.swagger.annotations.ApiOperation;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController()
public class TicketJSON {

    Logger logger = LoggerFactory.getLogger(getClass());
    @Autowired
    MovieService movieService;

    @Autowired
    CinemaService cinemaService;

    @Autowired
    OrderforgoodsService orderforgoodsService;

    @Autowired
    TicketService ticketService;

    @Autowired
    MoviesMapper moviesMapper;

    @Autowired
    PhotoMapper photoMapper;

    @Autowired
    EmailUtil emailUtil;

    @ResponseBody
    @ApiOperation("获取客户端登录请求:")
    @RequestMapping(value = "/api/userinfo", produces = "application/json;charset=utf-8")
    public Object doModelMovieParam(@RequestParam("user") String user,
                                    @RequestParam("paw") String paw) {

        logger.trace("odModelOrderForGoodsService:获取客户端登录请求");

        if(!user.contains("@")){
            Ticket user1 = ticketService.doQueryTicketByPhone(user);
            if(user1!=null){
                return user1;
            }else{
                return new Ticket();
            }
        }else{
            //如果是邮箱登录
            int code = emailUtil.doEmail(user);
            return code;
        }

    }
}
