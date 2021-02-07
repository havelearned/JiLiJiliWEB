package com.yinghua.application.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;

/**
 * @ClassName IndexController 访问 / 或者 index.hmnlt 是访问首页
 * @Description TODO
 * @Author Luojiaju
 * @crete 2020-12-13-17:09-12
 * @Version 1.0
 */
@Controller
public class IndexController {
    @RequestMapping("/")
    public String doIndex() {
        return "login";
    }


}
