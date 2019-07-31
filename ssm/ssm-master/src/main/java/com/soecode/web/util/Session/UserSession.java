package com.soecode.web.util.Session;

import com.soecode.web.util.MD5Util;

import java.io.Serializable;
import java.util.Map;
import java.util.UUID;

public class UserSession<T> implements Serializable{

        private static final long serialVersionUID = 111111112L;
        private String sessionId;
        private T user;
        private Map<String, String> userPermission;
        private String homePage;
        private long timestamp;

        public UserSession() {
            this.timestamp = System.currentTimeMillis();
        }

        public UserSession(T user, Map<String, String> userPermission) {
            this.sessionId = generateSessionId();
            this.user = user;
            this.userPermission = userPermission;
            this.timestamp = System.currentTimeMillis();
        }

        public UserSession(T user, Map<String, String> userPermission, String homePage) {
            this.sessionId = generateSessionId();
            this.user = user;
            this.userPermission = userPermission;
            this.homePage = homePage;
            this.timestamp = System.currentTimeMillis();
        }

        public String getSessionId() {
            return this.sessionId;
        }

        public void setSessionId(String sessionId) {
            this.sessionId = sessionId;
        }

        public T getUser() {
            return this.user;
        }

        public void setUser(T user) {
            this.user = user;
        }

        public Map<String, String> getUserPermission() {
            return this.userPermission;
        }

        public void setUserPermission(Map<String, String> userPermission) {
            this.userPermission = userPermission;
        }

        public long getTimestamp() {
            return this.timestamp;
        }

        public void setTimestamp(long timestamp) {
            this.timestamp = timestamp;
        }

        public String getHomePage() {
            return this.homePage;
        }

        public void setHomePage(String homePage) {
            this.homePage = homePage;
        }

        public static String generateSessionId() {
            return MD5Util.GetMD5Code(UUID.randomUUID().toString().replaceAll("-", ""));
        }
    }
