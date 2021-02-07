package com.yinghua.application.pojo;

import java.util.Date;

/**
 * @author Luojiaju
 * @description: 订单实体类
 * @return
 * @params
 * @data 2020/12/14 18:37
 **/
public class Orderforgoods {
    private String oId;

    private Integer oTid;

    private Integer oMid;

    private Integer oCid;

    private String oTphone;

    private String oTcard;

    private String oMmovieName;

    private String oCseatnumber;

    private String oTnickname;

    private Date oBookingdate;

    private Date oExpire;

    private Date oStartTime;

    public Orderforgoods() {
    }

    public Orderforgoods(String oId, Integer oTid, Integer oMid, Integer oCid, String oTphone, String oTcard, String oMmovieName, String oCseatnumber, String oTnickname, Date oBookingdate, Date oExpire, Date oStartTime) {
        this.oId = oId;
        this.oTid = oTid;
        this.oMid = oMid;
        this.oCid = oCid;
        this.oTphone = oTphone;
        this.oTcard = oTcard;
        this.oMmovieName = oMmovieName;
        this.oCseatnumber = oCseatnumber;
        this.oTnickname = oTnickname;
        this.oBookingdate = oBookingdate;
        this.oExpire = oExpire;
        this.oStartTime = oStartTime;
    }

    public String getoId() {
        return oId;
    }

    public void setoId(String oId) {
        this.oId = oId;
    }

    public Integer getoTid() {
        return oTid;
    }

    public void setoTid(Integer oTid) {
        this.oTid = oTid;
    }

    public Integer getoMid() {
        return oMid;
    }

    public void setoMid(Integer oMid) {
        this.oMid = oMid;
    }

    public Integer getoCid() {
        return oCid;
    }

    public void setoCid(Integer oCid) {
        this.oCid = oCid;
    }

    public String getoTphone() {
        return oTphone;
    }

    public void setoTphone(String oTphone) {
        this.oTphone = oTphone;
    }

    public String getoTcard() {
        return oTcard;
    }

    public void setoTcard(String oTcard) {
        this.oTcard = oTcard;
    }

    public String getoMmovieName() {
        return oMmovieName;
    }

    public void setoMmovieName(String oMmovieName) {
        this.oMmovieName = oMmovieName;
    }

    public String getoCseatnumber() {
        return oCseatnumber;
    }

    public void setoCseatnumber(String oCseatnumber) {
        this.oCseatnumber = oCseatnumber;
    }

    public String getoTnickname() {
        return oTnickname;
    }

    public void setoTnickname(String oTnickname) {
        this.oTnickname = oTnickname;
    }

    public Date getoBookingdate() {
        return oBookingdate;
    }

    public void setoBookingdate(Date oBookingdate) {
        this.oBookingdate = oBookingdate;
    }

    public Date getoExpire() {
        return oExpire;
    }

    public void setoExpire(Date oExpire) {
        this.oExpire = oExpire;
    }

    public Date getoStartTime() {
        return oStartTime;
    }

    public void setoStartTime(Date oStartTime) {
        this.oStartTime = oStartTime;
    }

    @Override
    public String toString() {
        return "Orderforgoods{" +
                "oId='" + oId + '\'' +
                ", oTid=" + oTid +
                ", oMid=" + oMid +
                ", oCid=" + oCid +
                ", oTphone='" + oTphone + '\'' +
                ", oTcard='" + oTcard + '\'' +
                ", oMmovieName='" + oMmovieName + '\'' +
                ", oCseatnumber='" + oCseatnumber + '\'' +
                ", oTnickname='" + oTnickname + '\'' +
                ", oBookingdate=" + oBookingdate +
                ", oExpire=" + oExpire +
                ", oStartTime=" + oStartTime +
                '}';
    }
}