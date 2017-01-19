package com.example.coolweather.db;

import org.litepal.crud.DataSupport;

/**
 * Created by qxz on 2017/1/19.
 * 存放省信息作为实体类
 */

public class Province extends DataSupport{
    private int id;
    private String provinceName;    //记录省的名字
    private String provinceCode;    //记录省的代号

    public int getId(){
        return id;
    }
    public void setId(int id){
        this.id = id;
    }
    public String getProvinceName(){
        return provinceName;
    }
    public void setProvinceName(String provinceName){
        this.provinceName = provinceName;

    }
    public String getProvinceCode(){
        return provinceCode;
    }
    public void setProvinceCode(){
        this.provinceCode = provinceCode;
    }
}

