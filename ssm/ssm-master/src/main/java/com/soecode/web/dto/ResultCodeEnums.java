package com.soecode.web.dto;


    /**
     *add by luzx 2019/07/14
     */

public enum ResultCodeEnums {

        NOT_LOGIN("202", "未登录"),

        NET_ERROR("203", "医院网络出错"),

        SERVER_EXCEPTION("-2", "服务端异常code"),
        TIMEOUT_EXCEPTION("-4", "业务超时"),
        OK("100", "成功"),
        SERVICE_ERROR("201", "服务器异常"),
        DEFAULT_ERROR("1000", "系统出错, 请联系管理员!"),
        ERROR("1001", "系统出错,错误未知!"),
        PARAM_ERROR("1002", "提交参数异常, 请联系管理员!"),
        SERVER_INNER_ERROR("1003", "请求错误，服务器内部发生异常！请联系管理员!"),
        SESSION_EXPIRE("1004", "未登录或会话已过期, 请重新登录!"),
        ILLEGAL_ACCESS("1005", "无权限,非法访问!"),
        RECORD_NOT_EXSIT("5001", "不存在此记录!"),
        DATA_SAVE_ERROR("5002", "保存出错!"),
        PARAM_VALIDATE_ERROR("5003", "输入参数不正确！"),
        SUCCESS_BUT_EXIST_ERROR("5004", "操作成功但存在处理不成功记录"),
        ILLEGAL_OPERATE("1005", "您无权限操作该记录!"),
        BALCK_PATIENT("1003", "就诊人已进入就诊诚信黑名单");

        private String code;
        private String msg;

        private ResultCodeEnums(String code, String msg) {
                this.code = code;
                this.msg = msg;
        }

        public String getCode() {
                return this.code;
        }

        public void setCode(String code) {
                this.code = code;
        }

        public String getMsg() {
                return this.msg;
        }

        public void setMsg(String msg) {
                this.msg = msg;
        }

            public static ResultCodeEnums getByCode(String code) {
                    for (ResultCodeEnums result : ResultCodeEnums.values()) {
                            if (result.getCode().equals(code)) {
                                    return result;
                            }
                    }
                    return null;
            }
}
