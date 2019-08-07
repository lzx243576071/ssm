package com.soecode.web.util;

import org.apache.commons.lang.StringUtils;
import org.apache.log4j.Logger;
import org.springframework.util.Assert;

import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 * Cookie 辅助类
 */
public class CookieUtils {

    private static Logger loggor = Logger.getLogger(CookieUtils.class);

    /**
     * 获得cookie
     *
     * @param request HttpServletRequest
     * @param name    cookie name
     * @return if exist return cookie, else return null.
     */
    public static Cookie getCookie(HttpServletRequest request,
                                   String name) {
        Assert.notNull(request);
        Cookie[] cookies = request.getCookies();
        if (cookies != null && cookies.length > 0) {
            for (Cookie c : cookies) {
                if (c.getName().equals(name)) {
                    return c;
                }
            }
        }
        return null;
    }

    /**
     * @param domains 域名：本方法中域名可以配置多个，以逗号分隔，用以支持多域名绑定到同一台服务器的需求
     */
    public static void addCookie(HttpServletRequest request,
                                 HttpServletResponse response,
                                 String name,
                                 String value,
                                 Integer expiry,
                                 String domains,
                                 String path) {
//        if (StringUtils.isNotEmpty(domains)) {
//            String[] split = domains.split(",");
//            for (String domain : split) {
                Cookie cookie = new Cookie(name, value);
                if (expiry != null) {
                    cookie.setMaxAge(expiry);
                }
//                if (StringUtils.isNotBlank(domain)) {
//                    cookie.setDomain(domain);
//                }
                if (StringUtils.isNotBlank(path)) {
                    cookie.setPath(path);
                }
        //        cookie.setHttpOnly(true);
                cookie.setSecure(false);
                response.addCookie(cookie);
//            }
//        }
    }
    /**
     * @param domains 域名：本方法中域名可以配置多个，以逗号分隔，用以支持多域名绑定到同一台服务器的需求
     */
    public static void addSecureCookie(HttpServletRequest request,
                                       HttpServletResponse response,
                                       String name,
                                       String value,
                                       Integer expiry,
                                       String domains,
                                       String path) {
        if (StringUtils.isNotEmpty(domains)) {
            String[] split = domains.split(",");
            for (String domain : split) {
                Cookie cookie = new Cookie(name, value);
                if (expiry != null) {
                    cookie.setMaxAge(expiry);
                }
                if (StringUtils.isNotBlank(domain)) {
                    cookie.setDomain(domain);
                }
                if (StringUtils.isNotBlank(path)) {
                    cookie.setPath(path);
                }

                cookie.setHttpOnly(true);
                cookie.setSecure(true);

                response.addCookie(cookie);
            }
        }
    }

    /**
     * 取消cookie
     *
     * @param request
     * @param response
     * @param name
     * @param domains
     */
    public static void cancleCookie(HttpServletRequest request,
                                    HttpServletResponse response,
                                    String name,
                                    String domains) {
        String[] split = domains.split(",");
        for (String domain : split) {
            Cookie cookie = new Cookie(name, "");
            cookie.setMaxAge(0);
            String ctx = request.getContextPath();
            cookie.setPath(StringUtils.isBlank(ctx) ? "/" : ctx);
            if (StringUtils.isNotBlank(domain)) {
                cookie.setDomain(domain);
            }
            response.addCookie(cookie);
        }
    }
}
