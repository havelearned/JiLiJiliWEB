package com.yinghua.application.controller;

import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;
import com.yinghua.application.pojo.Movies;
import com.yinghua.application.service.MovieService;
import com.yinghua.application.util.utilController.FileUploadController;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.multipart.MultipartFile;

import java.io.File;
import java.io.IOException;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.List;

/**
 * @ClassName MovieController  影片列表展示
 * @Description TODO
 * @Author Luojiaju
 * @crete 2020-12-14-16:18-43
 * @Version 1.0
 */

@RequestMapping("/movie")
@Controller
public class MovieController {
    private Integer UPDATE_MOVIE_ID=0;

    @Autowired
    MovieService movieService;


   /**
   * @description: doMovieList 展示所有的电影
   * @return java.lang.String
   * @params [model]
   * @data 2020/12/16 16:55
   * @author Luojiaju
   **/
    @GetMapping("/list")
    public String doMovieList(@RequestParam(value = "page" ,defaultValue = "1")Integer pageNum, Model model){
//        List<Movies> movies = movieService.doMovies();
        PageInfo pageInfo = movieService.doQueryMoviesPageHelper(pageNum);
        model.addAttribute("pageInfo",pageInfo);
        return "list";
    }

    /**
    * @description: 跳转到添加页面
    * @return
    * @params
    * @data 2020/12/16 16:55
    * @author Luojiaju
    **/
    @GetMapping("/addmovie")
    public String toAddMovie(){
        System.out.println("添加：MovieController.doAddMovie");

        return "addmovie/Addmovie";
    }

   /**
   * @description: 添加功能
   * @return java.lang.String
   * @params [cover, movieName, director, protagonist, support, qita, screen, xiajiashijian, model]
   * @data 2020/12/16 16:56
   * @author Luojiaju
   **/
    @PutMapping(value = "/Addthefilm",headers = "content-type=multipart/*")
    public String doAddmovie(@RequestParam("fengmian") MultipartFile cover,
                             @RequestParam("dingyingmingcheng") String movieName,
                             @RequestParam("daoyuan") String director,
                             @RequestParam("zhuyuan") String protagonist,
                             @RequestParam("peijiao") String support,
                             @RequestParam("qita") String qita,
                             @RequestParam("shangyingshijian") String screen,
                             @RequestParam("xiajiashijian") String xiajiashijian,
                             Model model
                             ){
        if(cover.isEmpty()){
            model.addAttribute("msg","这个是必填的： 封面");
            return "addmovie/Addmovie";
        }
        if(movieName.isEmpty()){
            model.addAttribute("msg","这个是必填的： 电影名称");
            return "addmovie/Addmovie";
        }
        if (director.isEmpty()){
            model.addAttribute("msg","这个是必填的： 导演");
            return "addmovie/Addmovie";
        }
        if (protagonist.isEmpty()){
            model.addAttribute("msg","这个是必填的： 主角");
            return "addmovie/Addmovie";
        }
        if (support.isEmpty()){
            model.addAttribute("msg","这个是必填的： 配角");
            return "addmovie/Addmovie";
        }
        if (screen.isEmpty()){
            model.addAttribute("msg","这个是必填的： 上映时间");
            return "addmovie/Addmovie";
        }
        int i = movieService.selectMaxID();

        SimpleDateFormat sf = new SimpleDateFormat("yyyy-MM-dd HH:mm");
        Date date=null;
        System.out.println(screen);
        screen=screen.replace("T"," ");
        try {
            date = sf.parse(screen);
        } catch (ParseException e) {
            e.printStackTrace();
        }
        Movies movies = new Movies(i+1,movieName,director,protagonist,support,date);
        movieService.doAddMovies(movies);
        return "redirect:/movie/list";
    }

    /**
    * @description: toMovieUpdate 获取需要更新电影的id 转发到修改页面
    * @return java.lang.String
    * @params [id, model]
    * @data 2020/12/16 16:57
    * @author Luojiaju
    **/
    @GetMapping(value = "/touchmove/{mId}")
    public String toMovieUpdate(@PathVariable("mId") Integer id,Model model){
        System.out.println("MovieController.movieUpdate:修改：----"+id);
        UPDATE_MOVIE_ID=id;
        Movies movies = movieService.selectMovieById(id);
        model.addAttribute("movies",movies);

        //转发到updatemovie文件夹下的Updatemovie视图
        return "updatemovie/Updatemovie";
    }

    /**
    * @description: doUpdate 更新电影
    * @return java.lang.String
    * @params [cover, movieName, director, protagonist, support, qita, screen, xiajiashijian, model]
    * @data 2020/12/16 16:57
    * @author Luojiaju
    **/
    @PostMapping(value = "/Update")
    public String doUpdate(
                            @RequestParam("fengmian") MultipartFile cover,
                           @RequestParam("dingyingmingcheng") String movieName,
                           @RequestParam("daoyuan") String director,
                           @RequestParam("zhuyuan") String protagonist,
                           @RequestParam("peijiao") String support,
                           @RequestParam("qita") String qita,
                           @RequestParam("shangyingshijian") String screen,
                           @RequestParam("xiajiashijian") String xiajiashijian,
                            Model model){

        SimpleDateFormat sf = new SimpleDateFormat("yyyy-MM-dd");
        Date date=null;
        try {

            date = sf.parse(screen);

        } catch (ParseException e) {
            e.printStackTrace();
        }
        Movies movies = new Movies(UPDATE_MOVIE_ID,movieName,director,protagonist,support,
                date==null?new Date(System.currentTimeMillis()):date);

        boolean b = movieService.doUpdateMovies(movies);
        if(b){
            System.out.println("修改成功");
            return "redirect:/movie/list";
        }
        model.addAttribute("errorMsg","修改失败，请重新选择");
        return "updatemovie/Updatemovie";
    }

    @DeleteMapping("/{mID}")
    public String doDeleteMovie(@PathVariable("mID") Integer mId,
                                Model model){
        System.out.println("删除的电影id："+mId);
        boolean b = movieService.doDeleteMovies(mId);
        if(b){
            return "redirect:/movie/list";
        }
        model.addAttribute("errorMsg","删除失败，请重新选择");
        return "redirect:/movie/list";
    }

}
