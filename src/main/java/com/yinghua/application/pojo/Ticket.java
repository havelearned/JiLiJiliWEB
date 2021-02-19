package com.yinghua.application.pojo;

import io.swagger.annotations.ApiModel;

/**
 * @author Luojiaju
 * @description: 购票者实体类
 * @return
 * @params
 * @data 2020/12/14 18:37
 **/

@ApiModel("Root 购票者对象")
public class Ticket {
    private Integer tId;

    private String tCard;

    private String tPhone;

    private String tGender;

    private String tNickname;

    public Integer gettId() {
        return tId;
    }

    public void settId(Integer tId) {
        this.tId = tId;
    }

    public String gettCard() {
        return tCard;
    }

    public void settCard(String tCard) {
        this.tCard = tCard == null ? null : tCard.trim();
    }

    public String gettPhone() {
        return tPhone;
    }

    public void settPhone(String tPhone) {
        this.tPhone = tPhone == null ? null : tPhone.trim();
    }

    public String gettGender() {
        return tGender;
    }

    public void settGender(String tGender) {
        this.tGender = tGender == null ? null : tGender.trim();
    }

    public String gettNickname() {
        return tNickname;
    }

    public void settNickname(String tNickname) {
        this.tNickname = tNickname == null ? null : tNickname.trim();
    }

    @Override
    public String toString() {
        return "Ticket{" +
                "tId=" + tId +
                ", tCard='" + tCard + '\'' +
                ", tPhone='" + tPhone + '\'' +
                ", tGender='" + tGender + '\'' +
                ", tNickname='" + tNickname + '\'' +
                '}';
    }
}