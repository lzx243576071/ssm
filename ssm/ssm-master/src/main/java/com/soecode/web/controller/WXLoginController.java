package com.soecode.web.controller;

/**
 * Created by Jiangyue on 2019/7/14.
 */

import com.alibaba.fastjson.JSONObject;
import com.google.gson.*;
import com.soecode.web.query.LoginQuery;
import com.soecode.web.service.WXLoginService;
import com.soecode.web.util.WXAuthUtil;
import org.apache.log4j.Logger;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.lang.reflect.Type;
import java.net.URLEncoder;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.HashMap;
import java.util.Map;


@Controller
@RequestMapping("/wx")
public class WXLoginController {

    @Autowired
    private WXLoginService wxLoginService;

    private static final Logger logger = Logger.getLogger(WXLoginController.class);
    public static final String APPID="wx999864fea89d73b4";
    public static final String APPSECRET ="0d92065c8f25b14fe8eea550223b38a8";
    private static final String TOKEN = "weixin";
    /**
 * 公众号微信登录授权
 * @param request
 * @param response
 */
 @RequestMapping(value = "/wxLogin", method = RequestMethod.GET)
 public void wxLogin(HttpServletRequest request,
                       HttpServletResponse response)
         throws ParseException, IOException {
        //这个url的域名必须要进行再公众号中进行注册验证，这个地址是成功后的回调地址
        String backUrl="http://jpzzss.natappfree.cc/wx/callBack";
        // 第一步：用户同意授权，获取code
        String url ="https://open.weixin.qq.com/connect/oauth2/authorize?appid="+ APPID
        + "&redirect_uri=" + URLEncoder.encode(backUrl)
        + "&response_type=code"
        + "&scope=snsapi_userinfo"
        + "&state=STATE#wechat_redirect";
        logger.info("forward重定向地址{" + url + "}");
       response.sendRedirect(url);
//     return "redirect:"+url;//必须重定向，否则不能成功
    }
/**
 * 公众号微信登录授权回调函数
 * @parameter
 */
@RequestMapping(value = "/callBack", method = RequestMethod.GET)
  public Map<String,Object> callBack(ModelMap modelMap, HttpServletRequest req, HttpServletResponse resp, LoginQuery query) throws ServletException, IOException, ParseException {
        /*
        * start 获取微信用户基本信息
        */
        String code =req.getParameter("code");
        //第二步：通过code换取网页授权access_token
        String url = "https://api.weixin.qq.com/sns/oauth2/access_token?appid="+WXAuthUtil.APPID
        + "&secret="+WXAuthUtil.APPSECRET
        + "&code="+code
        + "&grant_type=authorization_code";

        System.out.println("url:"+url);
        JSONObject jsonObject = WXAuthUtil.doGetJson(url);
                /*
        { "access_token":"ACCESS_TOKEN",
          "expires_in":7200,
          "refresh_token":"REFRESH_TOKEN",
          "openid":"OPENID",
          "scope":"SCOPE"
         }
        */
        String openid = jsonObject.getString("openid");
        String access_token = jsonObject.getString("access_token");
        String refresh_token = jsonObject.getString("refresh_token");
        //第五步验证access_token是否失效；展示都不需要
        String chickUrl="https://api.weixin.qq.com/sns/auth?access_token="+access_token+"&openid="+openid;
        JSONObject chickuserInfo = WXAuthUtil.doGetJson(chickUrl);
        System.out.println(chickuserInfo.toString());
        if(!"0".equals(chickuserInfo.getString("errcode"))){
        // 第三步：刷新access_token（如果需要）-----暂时没有使用,参考文档https://mp.weixin.qq.com/wiki，
        String refreshTokenUrl="https://api.weixin.qq.com/sns/oauth2/refresh_token?appid="+openid+"&grant_type=refresh_token&refresh_token="+refresh_token;

        JSONObject refreshInfo = WXAuthUtil.doGetJson(chickUrl);
                          /*
          * { "access_token":"ACCESS_TOKEN",
            "expires_in":7200,
            "refresh_token":"REFRESH_TOKEN",
            "openid":"OPENID",
            "scope":"SCOPE" }
          */
          System.out.println(refreshInfo.toString());
          access_token=refreshInfo.getString("access_token");
        }

        // 第四步：拉取用户信息(需scope为 snsapi_userinfo)
        String infoUrl = "https://api.weixin.qq.com/sns/userinfo?access_token="+access_token
            + "&openid="+openid
            + "&lang=zh_CN";
        System.out.println("infoUrl:"+infoUrl);
        JSONObject userInfo = WXAuthUtil.doGetJson(infoUrl);

        /*
        {  "openid":" OPENID",
          " nickname": NICKNAME,
          "sex":"1",
          "province":"PROVINCE"
          "city":"CITY",
          "country":"COUNTRY",g3MonUZtNHkdmzicIlibx6iaFqAc56vxLSUfpb6n5WKSYVY0ChQKkiaJSgQ1dZuTOgvLLrhJbERQQ4eMsv84eavHiaiceqxibJxCfHe
          "headimgurl":  "http://wx.qlogo.cn/mmopen//46",
          "privilege":[ "PRIVILEGE1" "PRIVILEGE2"   ],
          "unionid": "o6_bmasdasdsad6_2sgVt7hMZOPfL"
          }
        */
        System.out.println("JSON-----"+userInfo.toString());
//        System.out.println("名字-----"+userInfo.getString("nickname"));
//        System.out.println("头像-----"+userInfo.getString("headimgurl"));
        Gson gson = new Gson();
        Map<String,Object> map= new HashMap<>();
        map= gson.fromJson(userInfo.toString(), map.getClass());
        int sex =  new Double((Double) map.get("sex")).intValue();
        System.out.println(map);
        SimpleDateFormat sf = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
        String format = sf.format(new Date());
        Date nowdate = sf.parse(format);
        query.setOpenId(map.get("openid").toString());
        query.setUserSex(sex);
        query.setWecahtId(map.get("nickname").toString());
        query.setHeadimgUrl(map.get("headimgurl").toString());
        query.setCreateTime(nowdate);
        query.setUpdateTime(nowdate);
        wxLoginService.SaveUserInfo(query);

        return map;
  }


}
