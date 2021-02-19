package com.yinghua.application.pojo;

import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;

/**
 * @author Luojiaju
 * @description: 电影院实体类
 * @return
 * @params
 * @data 2020/12/14 18:37
 **/

@ApiModel("Cinema电影院")
public class Cinema {
    private Integer cId;

    private String cCname;

    private String cSeatnumber;

    private String c_Image;



    private Integer cGalleryful;

    public String getC_Image() {
        return c_Image;
    }

    public void setC_Image(String c_Image) {
        this.c_Image = c_Image;
    }

    public Integer getcId() {
        return cId;
    }

    public void setcId(Integer cId) {
        this.cId = cId;
    }

    public String getcCname() {
        return cCname;
    }

    public void setcCname(String cCname) {
        this.cCname = cCname == null ? null : cCname.trim();
    }

    public String getcSeatnumber() {
        return cSeatnumber;
    }

    public void setcSeatnumber(String cSeatnumber) {
        this.cSeatnumber = cSeatnumber == null ? null : cSeatnumber.trim();
    }

    public Integer getcGalleryful() {
        return cGalleryful;
    }

    public void setcGalleryful(Integer cGalleryful) {
        this.cGalleryful = cGalleryful;
    }
}