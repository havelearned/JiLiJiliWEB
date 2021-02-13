package com.yinghua.application.mapper;

import com.yinghua.application.pojo.Movies;
import org.apache.ibatis.annotations.Select;
import org.springframework.stereotype.Repository;

import java.util.List;

/**
 * @author Luojiaju
 * @description: 影片 功能接口
 * @return
 * @params
 * @data 2020/12/14 18:36
 **/

@Repository
public interface MoviesMapper {


    List<Movies>QueryMovieAndPhoto();


    /**
     * @return int
     * @description: selectMaxID  查询条目总数
     * @params []
     * @data 2020/12/20 14:44
     * @author Luojiaju
     **/
    int selectMaxID();

    Movies selectByid(Integer id);

    List<Movies> selectMovies();

    /**
     * @return java.util.List<com.yinghua.application.pojo.Movies>
     * @description:selectMoviesPage 分页查询
     * @params []
     * @data 2020/12/20 14:43
     * @author Luojiaju
     **/
    List<Movies> selectMoviesPage();


    int insert(Movies record);

    boolean deleteMovies(Integer id);

    boolean UpdateMovies(Movies movies);

    int insertSelective(Movies record);
}