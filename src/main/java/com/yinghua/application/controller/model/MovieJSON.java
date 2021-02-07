package com.yinghua.application.controller.model;


import com.alibaba.fastjson.JSON;
import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;
import com.yinghua.application.mapper.MoviesMapper;
import com.yinghua.application.pojo.*;
import com.yinghua.application.service.CinemaService;
import com.yinghua.application.service.MovieService;
import com.yinghua.application.service.OrderforgoodsService;
import com.yinghua.application.service.TicketService;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

import java.util.List;

@Controller
public class MovieJSON {
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
    /*
     *响应单个影片
     * */
    @ResponseBody
    @GetMapping("/modelmovie/param")
    public String  doModelMovieParam(@RequestParam("movieId") Integer moieid){
        logger.trace("odModelOrderForGoodsService:响应单个影片+分页");
        PageHelper.startPage(moieid,5);
        List<Movies> movies1 = moviesMapper.selectMoviesPage();
        PageInfo pageInfo = new PageInfo(movies1);
        List list = pageInfo.getList();
//        Movies movies = movieService.selectMovieById(moieid);
        return JSON.toJSONString(list);
    }

    /*
     *响应单个电影院
     * */
    @ResponseBody
    @GetMapping("/modelcinema/param")
    public String  doModelcinemaeParam(@RequestParam("cinemaId") Integer cinemaId){
        logger.trace("odModelOrderForGoodsService:响应单个电影院");
        Cinema cinema = cinemaService.QueryCinemaById(cinemaId);
        return JSON.toJSONString(cinema);
    }





    /*
     *响应订单
     * */
    @ResponseBody
    @GetMapping("/modelorderforgoodsService")
    public String  odModelOrderForGoodsService(){
        logger.trace("odModelOrderForGoodsService:响应订单");
        List<Orderforgoods> orderforgoodsList = orderforgoodsService.doQueryOrders();
        String orderForGoodsListString = JSON.toJSONString(orderforgoodsList);

        return orderForGoodsListString;
    }

    /*
     *响应购票者
     * */
    @ResponseBody
    @GetMapping("/modelticket")
    public String  odmModelTicket(){
        logger.trace("odModelOrderForGoodsService:响应购票者");
        List<Ticket> ticketList = ticketService.doQueryTickets();
        String ticketString = JSON.toJSONString(ticketList);

        return ticketString;
    }

    /**
     * 响应影片
     * */
    @ResponseBody
    @GetMapping("/modelmmovie")
    public String doModelmmovie(){
        logger.trace("odModelOrderForGoodsService:响应影片");
        List<Movies> listMovies = movieService.doMovies();
        String movies = JSON.toJSONString(listMovies);

        return movies;
    }


    /*
    *响应电源院
    * */
    @ResponseBody
    @GetMapping("/modelcinema")
    public String doModelCinema(){
        logger.trace("odModelOrderForGoodsService:响应电源院");
        List<Cinema> listCinemas = cinemaService.queryCinema();
        String cinemas = JSON.toJSONString(listCinemas);

        return cinemas;
    }
}
