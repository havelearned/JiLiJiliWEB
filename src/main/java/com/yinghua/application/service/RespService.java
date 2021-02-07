package com.yinghua.application.service;

import com.yinghua.application.util.Resp;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Service;
import org.springframework.web.multipart.MultipartFile;

import java.io.File;

/**
 * @ClassName RespService
 * @Description TODO
 * @Author Luojiaju
 * @crete 2020-12-22-17:12-54
 * @Version 1.0
 */

@Service
public class RespService {
    Logger logger = LoggerFactory.getLogger(getClass());
    /**
    * @description: 文件上传逻辑
        首先判断文件是否为空，如果为空返回 400 错误（客户端错误）
        获取文件的 扩展名 ，使用时间戳拼接名称

    * @return Resp<String>
    * @params file 文件对象
    * @data 2020/12/23 14:24
    * @author Luojiaju
    **/
    public Resp<String> upload(MultipartFile file){
        logger.trace("RespService.upload 文件上传逻辑");
        if(file.isEmpty()){
            return Resp.fail("400","文件为空！！");
        }
        //获取文件的扩展名
        String originalFilename = file.getOriginalFilename();
        String fileName=System.currentTimeMillis()+"."+originalFilename.substring(originalFilename.lastIndexOf(".")+1);
        String filePath="H:\\UserInfo\\";
        File dest=new File(filePath+fileName);

        if(!dest.getParentFile().exists())dest.getParentFile().mkdirs();
        try{
            file.transferTo(dest);
        }catch (Exception e){
            e.printStackTrace();
            return Resp.fail("500",originalFilename+"文件上传错误!");
        }
        return Resp.success(fileName);
    }
}
