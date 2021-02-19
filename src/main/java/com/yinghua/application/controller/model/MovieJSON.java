package com.yinghua.application.controller.model;


import com.alibaba.fastjson.JSON;
import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;
import com.yinghua.application.mapper.MoviesMapper;
import com.yinghua.application.mapper.PhotoMapper;
import com.yinghua.application.pojo.*;
import com.yinghua.application.service.CinemaService;
import com.yinghua.application.service.MovieService;
import com.yinghua.application.service.OrderforgoodsService;
import com.yinghua.application.service.TicketService;
import io.swagger.annotations.ApiOperation;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController()
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

    @Autowired
    PhotoMapper photoMapper;

    @ApiOperation("响应JSON加图片影片+分页")
    @GetMapping(value = "/modelmovie/param", produces = "application/json;charset=utf-8")
    public List<Movies> doModelMovieParam(@RequestParam("start") Integer start,
                                          @RequestParam("count") Integer count) {

        logger.trace("odModelOrderForGoodsService:响应JSON 加 图片 影片+分页");
        PageHelper.startPage(start, count);

        return moviesMapper.QueryMovieAndPhoto();
    }


    @ApiOperation("更具id获取电影院信息")
    @GetMapping(value = "/modelcinema/param", produces = "application/json;charset=utf-8")
    public Cinema doModelcinemaeParam(@RequestParam("cinemaId") Integer cinemaId) {
        logger.trace("odModelOrderForGoodsService:响应单个电影院");
        Cinema cinema = cinemaService.QueryCinemaById(cinemaId);
        return cinema;
    }


    @ApiOperation("所有的响应订单信息")
    @GetMapping("/modelorderforgoodsService")
    public List<Orderforgoods> odModelOrderForGoodsService() {
        logger.trace("odModelOrderForGoodsService:响应订单");
        List<Orderforgoods> orderforgoodsList = orderforgoodsService.doQueryOrders();

        return orderforgoodsList;
    }

    @ApiOperation("所有的购票者信息")
    @GetMapping("/modelticket")
    public List<Ticket> odmModelTicket() {
        logger.trace("odModelOrderForGoodsService:响应购票者");
        List<Ticket> ticketList = ticketService.doQueryTickets();

        return ticketList;
    }


    @ApiOperation("所有的影片信息")
    @GetMapping("/modelmmovie")
    public List<Movies> doModelmmovie() {
        logger.trace("odModelOrderForGoodsService:响应影片");
        List<Movies> listMovies = movieService.doMovies();

        return listMovies;
    }


    @ApiOperation("提供目前所有的电影院")
    @GetMapping("/modelcinema")
    public List<Cinema> doModelCinema() {
        logger.trace("odModelOrderForGoodsService:响应电影院");
        List<Cinema> listCinemas = cinemaService.queryCinema();

        return listCinemas;
    }
}
