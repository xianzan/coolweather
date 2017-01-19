package com.example.coolweather.util;

import okhttp3.OkHttpClient;
import okhttp3.Request;

/**
 * Created by qxz on 2017/1/19.
 * 与服务器交互
 */

public class HttpUtil {
    public static void sendOkHttpRequest(String address,okhttp3.Callback callback){
        OkHttpClient client = new OkHttpClient();
        Request request = new Request.Builder().url(address).build();
        client.newCall(request).enqueue(callback); //自动完成启动子线程，在子线程中执行HTTP请求，并将最终的结果毁掉到Okhttp的callback中
    }
}
