package com.yinghua.application.service;

import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;
import com.yinghua.application.mapper.MoviesMapper;
import com.yinghua.application.pojo.Movies;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

/**
 * @ClassName MovieService
 * @Description TODO
 * @Author Luojiaju
 * @crete 2020-12-14-16:41-41
 * @Version 1.0
 */
@Service
public class MovieService {
    @Autowired
    MoviesMapper moviesMapper;
    Logger logger = LoggerFactory.getLogger(getClass());
    //分页
    public  PageInfo doQueryMoviesPageHelper(Integer page){
        logger.trace("MovieService.doQueryMoviesPageHelper 分页");
        PageHelper.startPage(page,10);
        List<Movies> movies1 = moviesMapper.selectMoviesPage();
        PageInfo pageInfo = new PageInfo(movies1);

        return pageInfo;
    }

    //根据 id 修改
    public boolean doUpdateMovies(Movies movies){
        logger.trace("MovieService.doUpdateMovies 根据 id 修改");
        boolean b = moviesMapper.UpdateMovies(movies);
        return b;
    }

    //根据id删除
    public boolean doDeleteMovies(Integer id){
        logger.trace("MovieService.doDeleteMovies 根据id删除");
        boolean b = moviesMapper.deleteMovies(id);
        return b;
    }

    public Movies selectMovieById(Integer id){
        logger.trace("MovieService.selectMovieById 更具id查询影片");
        Movies movies = moviesMapper.selectByid(id);
        return movies;
    }

    //查找最后的id插入
    public int selectMaxID(){
        logger.trace("MovieService.selectMaxID 查找最后的id插入");
        int i = moviesMapper.selectMaxID();

        if(i==0){
            return 1;
        }
        return i;
    }

    //添加电影
    public Movies doAddMovies(Movies movies){
        logger.trace("MovieService.doAddMovies 添加电影");
        moviesMapper.insert(movies);
        return movies;
    }

    //查询所有影片
    public List<Movies> doMovies(){
        logger.trace("MovieService.doMovies 查询所有影片");
        List<Movies> movies = moviesMapper.selectMovies();

        return movies;
    }
}
