package com.soecode.web.util;

import com.alibaba.fastjson.JSON;
import com.alibaba.fastjson.JSONObject;
import org.apache.http.HttpEntity;
import org.apache.http.HttpResponse;
import org.apache.http.client.ClientProtocolException;
import org.apache.http.client.methods.HttpGet;
import org.apache.http.impl.client.DefaultHttpClient;
import org.apache.http.util.EntityUtils;

import java.io.IOException;

/**
 * Created by Jiangyue on 2019/7/14.
 * 模拟HTTP请求
 */

public class WXAuthUtil {
    public static final String APPID="wx999864fea89d73b4";
    public static final String APPSECRET ="0d92065c8f25b14fe8eea550223b38a8";
    private static final String TOKEN = "weixin";
    public static JSONObject doGetJson(String url) throws ClientProtocolException, IOException {
    JSONObject jsonObject =null;
    DefaultHttpClient client = new DefaultHttpClient();
    HttpGet httpGet =new HttpGet(url);
    HttpResponse response = client.execute(httpGet);
    HttpEntity entity =response.getEntity();
    if(entity!=null) {
          //把返回的结果转换为JSON对象
        String result = EntityUtils.toString(entity, "UTF-8");
        jsonObject =JSON.parseObject(result);
    }
    return jsonObject;
    }

}
