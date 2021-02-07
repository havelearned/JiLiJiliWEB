package com.yinghua.application.util.utilController;

import com.yinghua.application.pojo.Movies;
import com.yinghua.application.service.MovieService;
import com.yinghua.application.util.Boxo;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import java.util.ArrayList;
import java.util.List;
import java.util.Random;

/**
 * @ClassName BoxoController 票房控制器
 * @Description TODO
 * @Author Luojiaju
 * @crete 2020-12-20-16:22-12
 * @Version 1.0
 */

@Controller
public class BoxoController {
    Logger logger = LoggerFactory.getLogger(getClass());
    @Autowired
    MovieService movieService;

   /**
   * @description: 票房数据生成
   * @return
   * @params
   * @data 2020/12/24 15:41
   * @author Luojiaju
   **/
    @GetMapping("/boxo")
    public String toBoxoHeml(Model model){
        logger.trace("BoxoController.toBoxoHeml 票房数据生成");
         List<Boxo> boxo = new ArrayList<>();
        {
            List<Movies> movies = movieService.doMovies();
            int count = movieService.selectMaxID();
            Random random = new Random();
            for(int i=0;i<count-1;i++){
                double v = Double.parseDouble(String.valueOf(random.nextDouble()).substring(0, 4));
                Boxo boxo1 = new Boxo();
                boxo1.setMovies(movies.get(i).getmMovieName());
                boxo1.setCountboxo(random.nextInt(10000));
                boxo1.setShootingsession(random.nextInt(100));
                boxo1.setStanding(random.nextDouble()*100);
                boxo1.setStanding(v);
                boxo.add(boxo1);
            }
        }
        model.addAttribute("boxo",boxo);
        return "heandl/boxoffice";
    }


}
