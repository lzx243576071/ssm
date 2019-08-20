package com.soecode.web.filter;

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

/**
 * @登录检验过滤器
 */
public class LoginControlFilter implements Filter {

    private static Logger log = Logger.getLogger(LoginControlFilter.class);
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
            boolean startsWith = requestURI.startsWith(key);
            if (startsWith) {
                chain.doFilter(servletRequest, servletResponse);
                return;
            }
        }

        // 获取用户cookie
        Cookie userCookie = CookieUtils.getCookie(request, Constants.WEB_SESSSION_ID_KEY);
        Object sessionId = request.getSession().getAttribute(Constants.WEB_SESSSION_ID_KEY);
        if (sessionId == null) {
            redirectLogin(request, response, requestURI);
            return;
        }
        String sidStr = "";
        if (userCookie != null) {
            sidStr = userCookie.getValue();
        } else {
            //由于支付宝小程序登录request中无法使用Cookies,因此需要使用其他关键字代替  鲁军  陆涛   ttcf_dlsy这个关键字无规律，防止被窃取
            if (StringUtils.isNotEmpty(request.getParameter("ttcfDlsy"))){
                sidStr = request.getParameter("ttcfDlsy");
            }else {
                sidStr = sessionId.toString();
            }
        }


        // 获取session
        WebApplicationContext context = ApplicationContextUtil.getContext();


        RedisCacheServiceAdapter redis = (RedisCacheServiceAdapter) context.getBean("redisCacheServiceAdapter");
//        RedisCacheServiceAdapter redis = (RedisCacheServiceAdapter) context.getBean("redisCacheServiceAdapter");


        UserSession<SystemInfo> session = (UserSession<SystemInfo>) redis.get(sidStr);
        if (session == null) {
            redirectLogin(request, response, requestURI);
            return;
        }
        /*
         * 更新缓存
         */
        CookieUtils.addSecureCookie(request, response, Constants.WEB_SESSSION_ID_KEY, session.getSessionId(), BizCons.USER_SESSION_TIMEOUT, BizCons.APP_DOMAIN, "/");
        redis.set(session.getSessionId(), session, BizCons.USER_SESSION_TIMEOUT);
        
        /*
         * 存储到httpSession作用域中，方便后续的获取
         */
        HttpSession httpSession = request.getSession();
        httpSession.setAttribute(Constants.WEB_SESSSION_ID_KEY, session.getSessionId());
        httpSession.setAttribute(Constants.SESSSION_OBJ_KEY, session);

        chain.doFilter(servletRequest, servletResponse);
    }

    public void redirectLogin(HttpServletRequest request, HttpServletResponse response, String uri) throws IOException,
            ServletException {
        //如果是ajax请求返回json格式的未登录信息
        String callBack = request.getParameter("callback");
        if(StringUtils.isNotEmpty(callBack)){
            Result<String> result = Result.createFailResult();
            result.error(ResultCodeEnums.NOT_LOGIN);
            String jsonString = JSONObject.toJSONString(result);
            response.setCharacterEncoding("UTF-8");
            response.setContentType("application/json; charset=utf-8");
            PrintWriter out = null;
            try {
                out = response.getWriter();
                out.append(callBack+"("+jsonString+")");
            } catch (IOException e) {
                log.error(ExceptionUtils.getStackTrace(e));
            } finally {
                if (out != null) {
                    out.close();
                }
            }
            return;
        }

//        String requestedWith = request.getHeader("x-requested-with");
//        if (requestedWith != null && "XMLHttpRequest".equals(requestedWith)) {
//            // ajax请求
//            response.setStatus(403);
//            PrintWriter out = response.getWriter();
//            try{
//	            out.print("_NO_LOGIN_SESSION");
//	            out.flush();
//            }finally{
//            	out.close();
//            }
//            return;
//        } else {
//            String redirect = ConfigHelper.getRedirectUrl(request);
//            redirect = StringUtils.isEmpty(redirect) ? request.getContextPath() : redirect;
//            if (uri != null && uri.contains("customerQuery"))
//                response.sendRedirect(redirect + "/admin/customerQuery/login?url=" + request.getRequestURI());
//            else
//                response.sendRedirect(redirect + "/admin/login?url=" + request.getRequestURI());
//            return;
//
////            if (uri != null && uri.contains("customerQuery"))
////                request.setAttribute("url", request.getContextPath() + "/admin/customerQuery/login?url=" + request.getRequestURI());
////            else
////                request.setAttribute("url", request.getContextPath() + "/admin/login?url=" + request.getRequestURI());
////
////            request.getRequestDispatcher("/admin/tologin").forward(request, response);
//
//        }
    }

    @Override
    public void destroy() {
    }
}
