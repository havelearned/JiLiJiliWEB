package com.yinghua.application.service;

import com.yinghua.application.mapper.RootMapper;
import com.yinghua.application.pojo.Root;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;


/**
 * @ClassName RootLoginService
 * @Description TODO
 * @Author Luojiaju
 * @crete 2020-12-14-11:56-34
 * @Version 1.0
 */
@Service
public class RootLoginService {
    Logger logger = LoggerFactory.getLogger(getClass());
    @Autowired
    RootMapper  rootMapper;

    /**
    * @description:管理员登录验证
    * @return boolean
    * @params [name, password]
    * @data 2020/12/14 16:41
    * @author Luojiaju
    **/
    public boolean RootSelectName(String name,String password){
        logger.trace("RootLoginService.RootSelectName 管理员登录验证");
        if(name==null||name.equals("")||password==null||password.equals("")){
            return false;
        }
        Root root = rootMapper.selectRootByName(name);
        if(root!=null){
            if(root.getrName().equals(name)&&root.getrNo().equals(password)){
                return true;
            }
        }
        return false;
    }
}
