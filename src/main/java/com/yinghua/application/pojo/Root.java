package com.yinghua.application.pojo;

/**
 * @author Luojiaju
 * @description: 管理员实体类
 * @return
 * @params
 * @data 2020/12/14 18:37
 **/
public class Root {
    private Integer rId;

    private String rNo;

    private String rName;

    private String rMi;

    public Integer getrId() {
        return rId;
    }

    public void setrId(Integer rId) {
        this.rId = rId;
    }

    public String getrNo() {
        return rNo;
    }

    public void setrNo(String rNo) {
        this.rNo = rNo == null ? null : rNo.trim();
    }

    public String getrName() {
        return rName;
    }

    public void setrName(String rName) {
        this.rName = rName == null ? null : rName.trim();
    }

    public String getrMi() {
        return rMi;
    }

    public void setrMi(String rMi) {
        this.rMi = rMi == null ? null : rMi.trim();
    }
}