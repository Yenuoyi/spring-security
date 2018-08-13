package com.liby.springmvc.util;

import org.springframework.stereotype.Component;

import java.security.MessageDigest;
import java.security.NoSuchAlgorithmException;

/**
 * 功能：获取Md5加密后的密文
 * @Author Created by yebing
 * @Date 2018/8/11 22:07
 * @Version 1.0.0
 */
@Component
public class Md5Util {
    private static final String SALT = "lamb";
    public String encode(String password){
        password = password + SALT;
        StringBuffer stringBuffer = new StringBuffer();
        MessageDigest digest = null;
        try {
            digest = MessageDigest.getInstance("md5");
        } catch (NoSuchAlgorithmException e) {
            e.printStackTrace();
        }
        byte[] strByte = password.getBytes();
        byte[] result = digest.digest(strByte);
        System.out.println();
        for (byte aByte : result) {
            String s=Integer.toHexString(0xff & aByte);
            if(s.length()==1){
                stringBuffer.append(s);
            }else{
                stringBuffer.append(s);
            }

        }
        return stringBuffer.toString();
    }

    public static void main(String[] args){
        Md5Util md5Util = new Md5Util();
        System.out.println(md5Util.encode("123456"));
    }
}

