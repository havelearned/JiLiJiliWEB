package com.yinghua.application.util.utilController;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;



@Controller
public class IncomuController {
    Logger logger = LoggerFactory.getLogger(getClass());
    @GetMapping("/day/income.html")
    public String toIncomu(){
        logger.trace("IncomuController.toIncomu 今日收益");
        return "income";
    }
}
