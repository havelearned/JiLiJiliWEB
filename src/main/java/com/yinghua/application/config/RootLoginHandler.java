package com.yinghua.application.config;

import com.yinghua.application.pojo.Cinema;
import com.yinghua.application.service.CinemaService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import org.springframework.stereotype.Controller;
import org.springframework.web.servlet.HandlerInterceptor;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.util.List;

/**
 * @ClassName RootLoginHandler 登录过滤器
 * @Description TODO
 * @Author Luojiaju
 * @crete 2020-12-14-16:02-05
 * @Version 1.0
 */

public class RootLoginHandler implements HandlerInterceptor {

    /**
     * @return
     * @description: 执行目标方法之前拦截
     * @params
     * @data 2020/12/24 15:29
     * @author Luojiaju
     **/
    @Override
    public boolean preHandle(HttpServletRequest request, HttpServletResponse response, Object handler) throws Exception {
        System.out.println("执行了TestInterceptor的preHandle方法");
        try {
            //统一拦截（查询当前session是否存在user）(这里user会在每次登陆成功后，写入session)
            Object rooMan = request.getSession().getAttribute("rooMan");
            if (rooMan != null) {

                return true;
            }
            request.setAttribute("msg", "没有权限登录");
            response.sendRedirect(request.getContextPath() + "/");
        } catch (IOException e) {
            e.printStackTrace();
        }
        return false;//如果设置为false时，被请求时，拦截器执行到此处将不会继续操作
        //如果设置为true时，请求将会继续执行后面的操作
    }

}
