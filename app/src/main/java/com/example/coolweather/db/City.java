package com.example.coolweather.db;

import org.litepal.crud.DataSupport;

/**
 * Created by qxz on 2017/1/19.
 * 存放城市信息作为实体类
 */

public class City extends DataSupport {
    private int id;
    private String cityName;    //记录市的名字
    private int cityCode;    //记录市的代码号
    private int provinceId;  //记录当前市所属省的id

    public int getId() {
        return id;
    }

    public String getCityName() {
        return cityName;
    }

    public int getCityCode() {
        return cityCode;
    }

    public int getProvinceId() {
        return provinceId;
    }

    public void setId(int id) {
        this.id = id;
    }

    public void setCityName(String cityName) {
        this.cityName = cityName;
    }

    public void setCityCode(int cityCode) {
        this.cityCode = cityCode;
    }

    public void setProvinceId(int provinceId) {
        this.provinceId = provinceId;
    }
}
