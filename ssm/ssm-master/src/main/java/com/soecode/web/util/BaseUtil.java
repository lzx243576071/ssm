package com.soecode.web.util;

import org.springframework.beans.factory.annotation.Autowired;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 * Created by Jiangyue on 2019/7/14.
 */
public class BaseUtil {
    protected static final String _CSRF_RANDOM_TOKEN = "_CSRF_RANDOM_TOKEN";

    @Autowired
    private HttpServletRequest request;

    @Autowired
    private HttpServletResponse response;


    public HttpServletRequest getRequest() {
        return request;
    }

    public void setRequest(HttpServletRequest request) {
        this.request = request;
    }

    public HttpServletResponse getResponse() {
        return response;
    }

    public void setResponse(HttpServletResponse response) {
        this.response = response;
    }


}
