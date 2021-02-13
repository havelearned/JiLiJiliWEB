package com.yinghua.application.pojo;

import io.swagger.annotations.ApiModel;

import java.util.Date;

/**
 * @ClassName TicketAndOrderforgoods
 * @Description TODO
 * @Author Luojiaju
 * @crete 2020-12-19-17:52-37
 * @Version 1.0
 */


@ApiModel("TicketAndOrderings 购票者订单监控对象")
public class TicketAndOrderings {
    private String username;
    private String userPhone;
    private String userCard;
    private Date userOrder;
    private boolean userState;

    public TicketAndOrderings() {
    }

    public TicketAndOrderings(String username, String userPhone, String userCard, Date userOrder, boolean userState) {
        this.username = username;
        this.userPhone = userPhone;
        this.userCard = userCard;
        this.userOrder = userOrder;
        this.userState = userState;
    }

    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    public String getUserPhone() {
        return userPhone;
    }

    public void setUserPhone(String userPhone) {
        this.userPhone = userPhone;
    }

    public String getUserCard() {
        return userCard;
    }

    public void setUserCard(String userCard) {
        this.userCard = userCard;
    }


    public Date getUserOrder() {
        return userOrder;
    }

    public void setUserOrder(Date userOrder) {
        this.userOrder = userOrder;
    }

    public boolean isUserState() {
        return userState;
    }

    public void setUserState(boolean userState) {
        this.userState = userState;
    }

    @Override
    public String toString() {
        return "TicketAndOrderings{" +
                "username='" + username + '\'' +
                ", userPhone='" + userPhone + '\'' +
                ", userCard='" + userCard + '\'' +
                ", userOrder='" + userOrder + '\'' +
                ", userState=" + userState +
                '}';
    }
}
