package com.soecode.web.util;

import org.apache.commons.lang.StringUtils;

import java.io.UnsupportedEncodingException;
import java.security.MessageDigest;
import java.security.NoSuchAlgorithmException;
import java.util.Map;

public class MD5Util {

    // 全局数组
    private final static String[] strDigits = { "0", "1", "2", "3", "4", "5",
            "6", "7", "8", "9", "a", "b", "c", "d", "e", "f" };

    public MD5Util() {
    }

    // 返回形式为数字跟字符串
    private static String byteToArrayString(byte bByte) {
        int iRet = bByte;
        // System.out.println("iRet="+iRet);
        if (iRet < 0) {
            iRet += 256;
        }
        int iD1 = iRet / 16;
        int iD2 = iRet % 16;
        return strDigits[iD1] + strDigits[iD2];
    }

    // 返回形式只为数字
//    private static String byteToNum(byte bByte) {
//        int iRet = bByte;
//        System.out.println("iRet1=" + iRet);
//        if (iRet < 0) {
//            iRet += 256;
//        }
//        return String.valueOf(iRet);
//    }

    // 转换字节数组为16进制字串
    private static String byteToString(byte[] bByte) {
        StringBuffer sBuffer = new StringBuffer();
        for (int i = 0; i < bByte.length; i++) {
            sBuffer.append(byteToArrayString(bByte[i]));
        }
        return sBuffer.toString();
    }

    public static String getMD5Code(String strObj) {
        String resultString = null;
        try {
            resultString = strObj;
            MessageDigest md = MessageDigest.getInstance("MD5");
            // md.digest() 该函数返回值为存放哈希值结果的byte数组
            resultString = byteToString(md.digest(strObj.getBytes("utf-8")));
        } catch (NoSuchAlgorithmException ex) {
            ex.printStackTrace();
        } catch (UnsupportedEncodingException e) {
            e.printStackTrace();
        }
        return resultString;
    }

    /**
     * 用md5签名，返回签名串
     * @param paramsMap
     * @param key
     * @param bRemoveBlank true 去掉空值，false 不过滤空值
     * @return
     */
    public static String signWithMD5(Map<String, String> paramsMap, String key, boolean bRemoveBlank){
        String preSignStr;

        Map<String, String> sParaNew = ParamsUtil.paraFilter(paramsMap, bRemoveBlank);
        // 获取待签名字符串
        preSignStr = ParamsUtil.createLinkString(sParaNew);

        preSignStr += key;

        String sign = getMD5Code(preSignStr);
        return  sign.toUpperCase();
    }


    public static Boolean verfySign(String sign,Map<String, String> paramsMap,String key){

        if(StringUtils.isBlank(sign)){
            return false;
        }

        String signNew = signWithMD5(paramsMap, key, true);
        if(StringUtils.isNotBlank(signNew) && sign.equals(signNew)){
            return true;
        }else{
            signNew = signWithMD5(paramsMap, key, false);
            if(StringUtils.isNotBlank(signNew) && sign.equals(signNew)){
                return true;
            }
        }
        return false;
    }





        public static String GetMD5Code(String strObj) {
        String resultString = null;

        try {
            new String(strObj);
            MessageDigest md = MessageDigest.getInstance("MD5");
            resultString = byteToString(md.digest(strObj.getBytes()));
        } catch (NoSuchAlgorithmException var3) {
            var3.printStackTrace();
        }

        return resultString;
    }

        public static void main(String[] args) {
        System.out.println(GetMD5Code("gfse4352-+[]"));
    }



}
