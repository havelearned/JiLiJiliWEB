package com.yinghua.application.controller;

import com.yinghua.application.pojo.Root;
import com.yinghua.application.service.RootLoginService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;

import javax.servlet.http.Cookie;
import javax.servlet.http.HttpSession;

/**
 * @ClassName RootLogin 管理员登录信息校验
 * @Description TODO
 * @Author Luojiaju
 * @crete 2020-12-14-10:04-16
 * @Version 1.0
 */

@RequestMapping("/root")
@Controller
public class RootLoginController {

    @Autowired
    RootLoginService service;

    /**
     * @return
     * @description: 管理员登录验证
     * @params
     * @data 2020/12/24 15:36
     * @author Luojiaju
     **/

    @RequestMapping(value = "/login", method = RequestMethod.POST)
    public String RooLogin(@RequestParam(value = "rootName", required = false, defaultValue = "admin") String rootName,
                           @RequestParam(value = "rootPassword", required = false, defaultValue = "3333") String rootPassword,
                           @RequestParam(value = "rememberMe", required = false, defaultValue = "false") String rememberMe,
                           HttpSession session,
                           Model model) {


        boolean isExists = service.RootSelectName(rootName, rootPassword);

        System.out.println(isExists);
        if (isExists) {
            session.setAttribute("rooMan", rootName);
            if ("no".equals(rememberMe)) {
                Cookie cookie = new Cookie(rootName, rootPassword);
                cookie.setMaxAge(3000);
            }
            return "redirect:/main.html";
        }
        model.addAttribute("msg", "用户名或者密码错误");
        return "login";

    }

}
