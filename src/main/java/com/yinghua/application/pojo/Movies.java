package com.yinghua.application.pojo;

import org.springframework.format.annotation.DateTimeFormat;

import java.util.Date;

/**
 * @author Luojiaju
 * @description: 影片实体类
 * @return
 * @params
 * @data 2020/12/14 18:37
 **/
public class Movies {
    private Integer mId;

    private String mMovieName;

    private String mDirector;

    private String mProtagonist;

    private String mSupport;

    private Date mScreen;

    public Movies() {
    }

    public Movies(Integer mId, String mMovieName, String mDirector, String mProtagonist, String mSupport, Date mScreen) {
        this.mId = mId;
        this.mMovieName = mMovieName;
        this.mDirector = mDirector;
        this.mProtagonist = mProtagonist;
        this.mSupport = mSupport;
        this.mScreen = mScreen;
    }

    public Integer getmId() {
        return mId;
    }

    public void setmId(Integer mId) {
        this.mId = mId;
    }

    public String getmMovieName() {
        return mMovieName;
    }

    public void setmMovieName(String mMovieName) {
        this.mMovieName = mMovieName == null ? null : mMovieName.trim();
    }

    public String getmDirector() {
        return mDirector;
    }

    public void setmDirector(String mDirector) {
        this.mDirector = mDirector == null ? null : mDirector.trim();
    }

    public String getmProtagonist() {
        return mProtagonist;
    }

    public void setmProtagonist(String mProtagonist) {
        this.mProtagonist = mProtagonist == null ? null : mProtagonist.trim();
    }

    public String getmSupport() {
        return mSupport;
    }

    public void setmSupport(String mSupport) {
        this.mSupport = mSupport == null ? null : mSupport.trim();
    }

    public Date getmScreen() {
        return mScreen;
    }

    public void setmScreen(Date mScreen) {
        this.mScreen = mScreen;
    }

    @Override
    public String toString() {
        return "Movies{" +
                "mId=" + mId +
                ", mMovieName='" + mMovieName + '\'' +
                ", mDirector='" + mDirector + '\'' +
                ", mProtagonist='" + mProtagonist + '\'' +
                ", mSupport='" + mSupport + '\'' +
                ", mScreen=" + mScreen +
                '}';
    }
}