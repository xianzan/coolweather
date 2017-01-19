package com.example.coolweather.util;

import android.text.TextUtils;

import com.example.coolweather.db.City;
import com.example.coolweather.db.County;
import com.example.coolweather.db.Province;

import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

/**
 * Created by qxz on 2017/1/19.
 * 用途：用于解析和处理服务器返回的省级、市级、县级数据
 * 思路：使用JSONArray和JSONObject将数据解析出来，然后组装为实体类对象，最后调用save()方法将数据存储到数据库中
 */

public class Utility {
    /**
     * 解析和处理服务器返回的省级数据
     */
    public static boolean handleProvinceResponse(String response){
        if(!TextUtils.isEmpty(response)){ //如果服务器返回的数据不为空
            try{
                JSONArray allProvinces = new JSONArray(response);  //构建json数组对象
                for (int i = 0; i <allProvinces.length() ; i++) {
                    JSONObject provinceObject = allProvinces.getJSONObject(i);   //将数组中的json对象从第0个逐个取出来
                    Province province = new Province();
                    province.setProvinceName(provinceObject.getString("name"));//服务器返回的生数据{“id”:1,"name":北京}
                    province.setProvinceCode(provinceObject.getInt("id"));
                    province.save();

                }
                return true;

            } catch (JSONException e) {
                e.printStackTrace();
            }
        }
            return false;
    }


    /**
     * 解析和处理服务器返回的市级数据
     */
    public static boolean handleCityResponse(String response,int provinceId){
        if(!TextUtils.isEmpty(response)){
            try{
                JSONArray allCities = new JSONArray(response);
                for (int i = 0; i <allCities.length() ; i++) {
                    JSONObject cityObject = allCities.getJSONObject(i); //服务器返回数据格式：{"id":113,"name":"南京"}
                    City city = new City();
                    city.setCityName(cityObject.getString("name"));
                    city.setCityCode(cityObject.getInt("id"));
                    city.setProvinceId(provinceId);
                    city.save();

                }
                return true;

            }catch (JSONException e){
                e.printStackTrace();
            }
        }
        return false;
    }

    /**
     * 解析和处理服务器返回的县级数据
     */
    public static boolean handleCoutyResponse(String response,int cityId){
        if(!TextUtils.isEmpty(response)){
            try{
                JSONArray allCounties = new JSONArray(response);
                for (int i = 0; i <allCounties.length() ; i++) {
                    JSONObject countyObject = allCounties.getJSONObject(i); //json数据格式：{"id":924,"name":"吴江","weather_id":"CN101190407"}
                    County county = new County();
                    county.setCountyName(countyObject.getString("name"));
                    county.setWeatherId(countyObject.getString("weather_id"));
                    county.setCityId(cityId);

                }
                return  true;
            }catch (JSONException e){
                e.printStackTrace();
            }

        }
        return false;

    }
}
