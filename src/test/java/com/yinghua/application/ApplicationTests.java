/*
package com.yinghua.application;
import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;
import com.yinghua.application.mapper.OrderforgoodsMapper;
import com.yinghua.application.pojo.Movies;
import com.yinghua.application.pojo.Orderforgoods;
import com.yinghua.application.service.*;
import org.junit.jupiter.api.Test;
import org.mybatis.generator.exception.InvalidConfigurationException;
import org.mybatis.generator.exception.XMLParserException;
import org.mybatis.spring.annotation.MapperScan;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.config.AutowireCapableBeanFactory;
import org.springframework.boot.test.context.SpringBootTest;

import javax.sql.DataSource;
import java.io.IOException;
import java.sql.SQLException;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.List;


@SpringBootTest
@MapperScan("com.yinghua.application.mapper")
class ApplicationTests {
    @Autowired
    DataSource dataSource;

    @Autowired
    RootLoginService service;

    @Autowired
    MovieService movieService;

    @Autowired
    OrderforgoodsMapper orderforgoods;

    @Autowired
    TicketService ticketService;

    @Autowired
    CinemaService cinemaService;


    @Test
    void doSelectMoviesPageHelper(){
        PageInfo pageInfo = movieService.doQueryMoviesPageHelper(2);


    }

    @Test
    void doQueryTickets(){
        ticketService.doQueryTickets();
    }

    @Test
     void TestQueryOrder(){
//        Orderforgoods orderforgoods = this.orderforgoods.selectOrderByid("1");
//        System.out.println(orderforgoods);
        List<Orderforgoods> orderforgoods = this.orderforgoods.selectOrders();

        for (Orderforgoods s:orderforgoods) {
            System.out.println(s);
        }
//        boolean b = orderforgoods.deleteOrderById("1");
//        System.out.println(b);

    }

    @Test
    void TestQueryCinema(){
        cinemaService.queryCinema();


    }


    @Test
    void TestQueryCinemaById(){
        cinemaService.QueryCinemaById(5);

    }


    @Test
    void TestDoUpdateMovies(){
        Movies movies = new Movies(7, "神奇女侠", "模式的发顺丰", "luojiaju", "yinghucn", new Date());
        boolean b = movieService.doUpdateMovies(movies);
        System.out.println(b);

    }

    @Test
    void TestDoDeleteMovies(){
        movieService.doDeleteMovies(5);

    }

    @Test
    void TestDoMovies(){
        movieService.doMovies();
    }


    @Test
    void TestDoAddMovies() throws ParseException {

        SimpleDateFormat sf = new SimpleDateFormat("yyyy-MM-dd");
        String dateStr = "2016-12-31";
        Date date = sf.parse(dateStr);
        Movies movies = new Movies(5,"jj","luojijau","zhangzhenjing","yuajchh",date);

        int i = movieService.selectMaxID();
        System.out.println(i);


//        movieService.doAddMovies(movies);
    }

    @Test
    void TestSelectMovieById(){
        Movies movies = movieService.selectMovieById(2);
        System.out.println(movies);
    }

    @Test
    void TestSelectName(){
        boolean isExists = service.RootSelectName("Luojijau","205339");
//        boolean isExists = service.RootSelectName("Luojijau1123123","12312312");
        System.out.println(isExists);
    }

    @Test
    void TestDB() throws SQLException {
       */
/* System.out.println("============================================"+dataSource.getClass());
        System.out.println("============================================"+dataSource.getConnection());
        List<Root> roots = rootMapper.selectRoots();
        for (Root root :roots) {
            System.out.println(root.getrId());
            System.out.println(root.getrMi());
            System.out.println(root.getrName());
            System.out.println(root.getrNo());
        }*//*


    }



    
    */
/*
    * @description:逆向生成
    * @return 
    * @params 
    * @data 2020/12/13 18:31
    * @author Luojiaju
    **//*


    @Test
    void contextLoads() throws InterruptedException, SQLException, IOException, XMLParserException, InvalidConfigurationException {
      */
/*  List<String> warnings = new ArrayList<String>();
        boolean overwrite = true;
        File configFile = new File("mbg.xml");
        ConfigurationParser cp = new ConfigurationParser(warnings);
        Configuration config = cp.parseConfiguration(configFile);
        DefaultShellCallback callback = new DefaultShellCallback(overwrite);
        MyBatisGenerator myBatisGenerator = new MyBatisGenerator(config,
                callback, warnings);
        myBatisGenerator.generate(null);
        System.out.println("生成完毕");*//*

    }



}
*/
