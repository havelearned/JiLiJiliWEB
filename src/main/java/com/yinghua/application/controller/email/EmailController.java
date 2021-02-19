package com.yinghua.application.controller.email;

import com.yinghua.application.util.EmailUtil;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

@Controller
public class EmailController {
    @Autowired
    EmailUtil emailUtil;

    @ResponseBody
    @RequestMapping(value = "/email/{userEmail}")
    public String doEmail(@PathVariable("userEmail") String userEmail){
        int code = emailUtil.doEmail(userEmail);
        return code+"";
    }
}
