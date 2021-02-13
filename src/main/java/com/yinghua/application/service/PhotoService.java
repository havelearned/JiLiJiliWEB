package com.yinghua.application.service;

import com.yinghua.application.mapper.PhotoMapper;
import com.yinghua.application.pojo.Photo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class PhotoService {

    @Autowired
    PhotoMapper photoMapper;

    public List<Photo> getAllPhoto(){

        return photoMapper.getAllPhoto();
    }

}
