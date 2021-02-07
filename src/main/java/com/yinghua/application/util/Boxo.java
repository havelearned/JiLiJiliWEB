package com.yinghua.application.util;

import com.yinghua.application.pojo.Movies;
import com.yinghua.application.service.MovieService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.util.ArrayList;
import java.util.List;
import java.util.Random;

/**
 * @author Luojiaju
 * @description: movies 电影名称
 * countboxo 综合票房
 * Standing 票房占比
 * shootingsession 排片场次
 * @return
 * @params
 * @data 2020/12/21 10:40
 **/

public class Boxo {
    private String movies;
    private Integer countboxo;
    private double Standing;
    private Integer shootingsession;

    public Boxo() {
    }

    public Boxo(String movies, Integer countboxo, double standing, Integer shootingsession) {
        this.movies = movies;
        this.countboxo = countboxo;
        Standing = standing;
        this.shootingsession = shootingsession;
    }

    public String getMovies() {
        return movies;
    }

    public void setMovies(String movies) {
        this.movies = movies;
    }

    public Integer getCountboxo() {
        return countboxo;
    }

    public void setCountboxo(Integer countboxo) {
        this.countboxo = countboxo;
    }

    public double getStanding() {
        return Standing;
    }

    public void setStanding(double standing) {
        Standing = standing;
    }

    public Integer getShootingsession() {
        return shootingsession;
    }

    public void setShootingsession(Integer shootingsession) {
        this.shootingsession = shootingsession;
    }

    @Override
    public String toString() {
        return "Boxo{" +
                "movies='" + movies + '\'' +
                ", countboxo=" + countboxo +
                ", Standing=" + Standing +
                ", shootingsession=" + shootingsession +
                '}';
    }
}
