package com.yinghua.application.mapper;

import com.yinghua.application.pojo.Root;
import org.apache.ibatis.annotations.*;
import org.springframework.stereotype.Repository;

import java.util.List;

/**
 * @author Luojiaju
 * @description: 管理员 功能接口
 * @return
 * @params
 * @data 2020/12/14 11:31
 **/
@Repository
public interface RootMapper {
    int insert(Root record);

    int insertSelective(Root record);

    List<Root> selectRoots();

    Root selectRootByName(String rootName);

    Root getRootById(Integer id);

    int addRoot(Root root);

    int updateRoot(Root root);

    int deleteRoot(int id);
}