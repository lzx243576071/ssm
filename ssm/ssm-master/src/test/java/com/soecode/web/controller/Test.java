package com.soecode.web.controller;

//import com.google.gson.Gson;
import com.soecode.web.message.MessageBean;
import com.soecode.web.message.MessageClient;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.net.HttpURLConnection;
import java.net.URL;
import java.security.MessageDigest;
import java.util.HashMap;
import java.util.Map;

//import static org.apache.poi.util.HexDump.toHex;

/**
 * Created by Jiangyue on 2019/7/11.
 */
public class Test {
      public static void main(String[] args) throws Exception {
        OutputStreamWriter out = null;
        BufferedReader reader = null;
        String response="";
        String Params = "";
        String appid= "wx999864fea89d73b4";
        String  secret = "0d92065c8f25b14fe8eea550223b38a8";
//
        try {
            URL httpUrl = null; //HTTP URL类 用这个类来创建连接
            //创建URL
            httpUrl = new URL("https://api.weixin.qq.com/cgi-bin/token?grant_type=client_credential&appid="+appid+"&secret="+secret+"");
            //建立连接
            HttpURLConnection conn = (HttpURLConnection) httpUrl.openConnection();
            conn.setRequestMethod("POST");
            conn.setRequestProperty("Content-Type", "application/json");
            conn.setRequestProperty("connection", "keep-alive");
            conn.setUseCaches(false);//设置不要缓存
            conn.setInstanceFollowRedirects(true);
            conn.setDoOutput(true);
            conn.setDoInput(true);
            conn.connect();
            //POST请求
            out = new OutputStreamWriter(
                    conn.getOutputStream());
            out.write(Params);
            out.flush();
            //读取响应
            reader = new BufferedReader(new InputStreamReader(
                    conn.getInputStream(),"utf-8"));
            String lines;
            while ((lines = reader.readLine()) != null) {
                lines = new String(lines.getBytes());
                response+=lines;
            }
            reader.close();
            // 断开连接
            conn.disconnect();
//            log.info(response.toString());
        } catch (Exception e) {
            System.out.println("发送 POST 请求出现异常！"+e);
            e.printStackTrace();
        }
        //使用finally块来关闭输出流、输入流
        finally{
            try{
                if(out!=null){
                    out.close();
                }
                if(reader!=null){
                    reader.close();
                }
            }
            catch(IOException ex){
                ex.printStackTrace();
            }
        }
//        Gson gson = new Gson();
//        Map<String,Object> map= new HashMap<>();
//        map= gson.fromJson(response, map.getClass());
//        String msg = map.get("msg").toString().substring(0,4);
//        if(!msg.equals("未知错误")){
//            map.put("result",200);
//            map.put("url","");
//        }
        System.out.println(response);
        return ;
    }
}
