package com.soecode.web.util.constants;

public class Constants {

    /**
     * 默认查询页码
     */
    public static final Integer pageNum = 0;
    /**
     * 默认每个页面查询数量
     */
    public static final Integer pageSize = 10;


    /**
     * session加密字符
     */
    public static final String CRYPT_KEY = "ssm";

    public static final String SESSSION_ID_KEY = "sessionId";
    public static final String SESSSION_OBJ_KEY = "sessionOdj";
    public static final String SESSSION_DOCT_OBJ_KEY = "sessionDoctOdj";
    public static final String SESSION_PIROS_TOKEN_KEY = "sessionPirosToken";
    public static final String SESSION_PIROS_APPID_KEY = "sessionPirosAppId";



    //用户端sessionId
    public static final String WEB_SESSSION_ID_KEY = "sessionid";
    public static final String WEB_USER_ID_KEY = "userid";
    public static final String WEB_SESSSION_TRACK_KEY = "trackid";//跟踪用户id

    //用户登录错误重试次数key
    public static final String LOGIN_RETRY_PRIFIX = "login_retry";
    public static final int LOGIN_RETRY_INVALID = 60 * 3;

    // 获取用户注册两次操作之间的间隔时间
    public static final String REG_DELAY_KEY = "reg-delay-";//
    public static final Integer REG_DELAY_TIME = 60;
    // 获取用户忘记密码操作之间的时间间隔
    public static final String PWD_DELAY_KEY = "pwd-delay-";
    //用户用户忘记密码重试次数key
    public static final String PWD_RETRY_PRIFIX = "pwd_retry";
    //用户注册错误重试次数key
    public static final String REG_RETRY_PRIFIX = "reg_retry";

    public static final String DOCTOR_XSS_SESSSION_ID_KEY = "remote_vis_doct_session_id";


    // 手机验证码REDIS KEY
    public static final String REST_PHONE = "newRestPhone-";       // redis key
    public static final Integer CODE_COUNT = 10;                 // 限制次数
    public static final Integer LIMIT_TIME = 60 * 60 * 24;           // redis 缓存时间：24小时

    public static final Integer PASSWORD_RETRY_NUM = 5;                 // 密码重试次数

    // 获取验证码两次操作之间的间隔时间
    public static final String VALIDATE_DELAY_KEY = "validate-delay-";//
    public static final Integer VALIDATE_DELAY_TIME = 60;


    //验证码登录token
    public static final String VALIDATE_LOGIN_TOKEN= "validate-token-";//

    /**
     * 用户修改账号信息的token
     */
    public static final String CHANGE_ACCOUNT = "change-account-";
    public static final int CHANGE_ACCOUNT_EXPIRED_TIME = 10 * 60;

    /**
     * 图片最大大小 5M
     */
    public static final int MAX_IMAGE_SIZE_REF = 1024 * 1024 * 5;

}
