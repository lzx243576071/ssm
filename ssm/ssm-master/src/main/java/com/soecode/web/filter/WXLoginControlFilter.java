package com.soecode.web.filter;

import com.alibaba.fastjson.JSON;
import com.alibaba.fastjson.JSONObject;
import com.soecode.web.cache.RedisCacheServiceAdapter;
import com.soecode.web.dto.Result;
import com.soecode.web.dto.ResultCodeEnums;
import com.soecode.web.entity.SystemInfo;
import com.soecode.web.util.ApplicationContextUtil;
import com.soecode.web.util.CookieUtils;
import com.soecode.web.util.Session.BizCons;
import com.soecode.web.util.Session.UserSession;
import com.soecode.web.util.constants.Constants;
import org.apache.commons.lang.StringUtils;
import org.apache.commons.lang.exception.ExceptionUtils;
import org.apache.log4j.Logger;
import org.springframework.web.context.WebApplicationContext;

import javax.servlet.*;
import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.HashMap;
import java.util.Map;
import java.util.Set;

public class WXLoginControlFilter implements Filter{

        private static Logger log = Logger.getLogger(WXLoginControlFilter.class);
        private static Map<String, String> noFilterMap = new HashMap<String, String>();

        @Override
        public void init(FilterConfig filterConfig) throws ServletException {
        String noFilter = filterConfig.getInitParameter("noFilter");
        if (StringUtils.isNotBlank(noFilter)) {
            String[] split = noFilter.split(",");
            for (String s : split) {
                noFilterMap.put(s, s);
            }
        }
    }

        @Override
        public void doFilter(ServletRequest servletRequest, ServletResponse servletResponse, FilterChain chain)
            throws IOException, ServletException {
        HttpServletRequest request = (HttpServletRequest) servletRequest;
        HttpServletResponse response = (HttpServletResponse) servletResponse;

        String contextPath = request.getContextPath();
        String requestURI = request.getRequestURI();
        requestURI = requestURI.substring(contextPath.length(), requestURI.length());
        requestURI = requestURI.split("\\?")[0];

        Set<String> keySet = noFilterMap.keySet();
        for (String key : keySet) {
            boolean startsWith;
            if(key.equals("/")){
                startsWith = requestURI.equals(key);
            }else {
                startsWith = requestURI.startsWith(key);
            }
            if (startsWith) {
                chain.doFilter(servletRequest, servletResponse);
                return;
            }
        }

        // 获取用户cookie
        Cookie userCookie = CookieUtils.getCookie(request, Constants.WX_SESSSION_TOKEN_ID);
            if (userCookie == null) {
                redirectLogin(request, response, requestURI);
                return;
            }


        // 获取session
        WebApplicationContext context = ApplicationContextUtil.getContext();


//        RedisCacheServiceAdapter redis = (RedisCacheServiceAdapter) context.getBean("redisCacheServiceAdapter");
//        RedisCacheServiceAdapter redis = (RedisCacheServiceAdapter) context.getBean("redisCacheServiceAdapter");


        /*
         * 更新缓存
         */
        CookieUtils.addSecureCookie(request, response, Constants.WX_SESSSION_TOKEN_ID, "" + userCookie, BizCons.WX_ACCESSTOKEN_TIMEOUT, BizCons.APP_DOMAIN, "/");


        chain.doFilter(servletRequest, servletResponse);
    }

        public void redirectLogin(HttpServletRequest request, HttpServletResponse response, String uri) throws IOException,
            ServletException {
            Result result=Result.createFailResult();
            result.setMsg("未登录或已超时");
            String jsonpCallback = (String) request.getParameter("callback");
            response.setCharacterEncoding("utf-8");
            response.setContentType("application/json; charset=utf-8");
            response.setStatus(200);
            PrintWriter out = response.getWriter();
            try{
                out.print(jsonpCallback+"("+ JSON.toJSON(result)+")");
                out.flush();
            }finally{
                if (out != null) {
                    out.close();
                }
            }

            return;

    }

        @Override
        public void destroy() {
    }
}
