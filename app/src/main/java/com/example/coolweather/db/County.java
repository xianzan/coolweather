package com.example.coolweather.db;

import org.litepal.crud.DataSupport;

/**
 * Created by qxz on 2017/1/19.
 * 记录县的信息
 */

public class County extends DataSupport{
    private int id;
    private String countyName;  //县的名字
    private String weatherId;   //天气的id号
    private int cityId;         //所属于城市的id

    public int getId() {
        return id;
    }

    public String getCountyName() {
        return countyName;
    }

    public String getWeatherId() {
        return weatherId;
    }

    public int getCityId() {
        return cityId;
    }

    public void setId(int id) {
        this.id = id;
    }

    public void setCountyName(String countyName) {
        this.countyName = countyName;
    }

    public void setWeatherId(String weatherId) {
        this.weatherId = weatherId;
    }

    public void setCityId(int cityId) {
        this.cityId = cityId;
    }
}
