package com.yinghua.application.mapper;

import com.yinghua.application.pojo.Cinema;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Repository;

import java.util.List;

/**
 * @author Luojiaju
 * @description: 电影院 功能接口
 * @return
 * @params
 * @data 2020/12/14 18:35
 **/
@Repository
public interface CinemaMapper {
    //获取日志对象(记录器)

    Cinema selectCinemaById(Integer id);

    List<Cinema> selectCinema();

    int insert(Cinema record);

    int insertSelective(Cinema record);
}