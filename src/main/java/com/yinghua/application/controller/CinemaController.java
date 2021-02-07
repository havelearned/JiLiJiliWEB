package com.yinghua.application.controller;

import com.yinghua.application.pojo.Cinema;
import com.yinghua.application.pojo.Movies;
import com.yinghua.application.service.CinemaService;
import com.yinghua.application.service.MovieService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

import java.util.List;

/**
 * @ClassName CinemaController
 * @Description TODO
 * @Author Luojiaju
 * @crete 2020-12-18-12:50-56
 * @Version 1.0
 */

@Controller
public class CinemaController {
    @Autowired
    CinemaService cinemaService;
    List<Cinema> cinemas;

    @Autowired
    MovieService movieService;


    /**
     * @return java.lang.String
     * @description: doQueryCinema  分配首页view
     * @params [model]
     * @data 2020/12/24 15:32
     * @author Luojiaju
     **/
    @RequestMapping("/main.html")
    public String doQueryCinema(Model model) {
        cinemas = cinemaService.queryCinema();
        model.addAttribute("cinemas", cinemas);
        return "dashboard";
    }

    /**
     * @return
     * @description: 处理 Filmstatistics 请求，获取 影院id，更具影院id分配视图
     * @params
     * @data 2020/12/24 15:32
     * @author Luojiaju
     **/
    @GetMapping("/Filmstatistics")
    public String doFilmStatistics(@RequestParam("cinameId") String cinameId,
                                   Model model) {
        cinemas = cinemaService.queryCinema();
        int id = Integer.parseInt(cinameId);
        Cinema cinema = cinemaService.QueryCinemaById(id);
        Movies movies = movieService.selectMovieById(id);

        model.addAttribute("cinemas", cinemas);
        model.addAttribute("cinema", cinema);
        model.addAttribute("movies", movies);

        return "multiplexlist/multiplex";
    }
}
