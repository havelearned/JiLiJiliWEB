package com.yinghua.application.mapper;

import com.yinghua.application.pojo.Photo;
import org.apache.ibatis.annotations.Select;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface PhotoMapper {

    @Select("select * from d_photo,d_movies where d_photo.P_id=d_movies.M_ID;")
    List<Photo> getAllPhoto();

}
