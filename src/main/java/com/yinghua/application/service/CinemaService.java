package com.yinghua.application.service;

import com.yinghua.application.mapper.CinemaMapper;
import com.yinghua.application.pojo.Cinema;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

/**
 * @ClassName CinemaService
 * @Description TODO
 * @Author Luojiaju
 * @crete 2020-12-18-12:43-42
 * @Version 1.0
 */
@Service
public class CinemaService {
    @Autowired
    CinemaMapper cinemaMapper;
    Logger logger = LoggerFactory.getLogger(getClass());
    //查询所有影院
    public List<Cinema> queryCinema(){
        logger.trace("CinemaService.queryCinema 查询所有的影院");
        List<Cinema> cinemaList = cinemaMapper.selectCinema();
        return cinemaList;
    }

    //更具id查询所有影院
    public Cinema QueryCinemaById(int id){
        logger.trace("CinemaService.QueryCinemaById 更具id查询所有影院");
        Cinema cinema = cinemaMapper.selectCinemaById(id);
        if(cinema!=null){
            return cinema;
        }
        throw new RuntimeException("cinema: 为空");
    }
}
