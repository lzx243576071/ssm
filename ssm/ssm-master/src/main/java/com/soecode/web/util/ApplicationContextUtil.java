package com.soecode.web.util;

import org.springframework.web.context.WebApplicationContext;

public class ApplicationContextUtil {
    public static WebApplicationContext webApplicationContext;

    public static WebApplicationContext getContext() {
        return webApplicationContext;
    }

    public static void setContext(WebApplicationContext context) {
        webApplicationContext = context;
    }
}

