package com.liby.springmvc.config.springsecurity;

import com.liby.springmvc.util.Md5Util;
import org.apache.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.authentication.encoding.MessageDigestPasswordEncoder;
import org.springframework.stereotype.Component;

/**
 * 功能：密码认证处理器，继承MessageDigestPasswordEncoder类，重写密码认证方法。
 *       <password-encoder ref="messageDigestPasswordEncoderImpl"></password-encoder>搭配使用
 * @Author: yebing
 * @Date: 2018-8-13 12:32
 * @Version 1.0.0
 */
public class MessageDigestPasswordEncoderImpl extends MessageDigestPasswordEncoder {
    @Autowired
    private Md5Util md5Util;
    private static Logger logger = Logger.getLogger(MessageDigestPasswordEncoderImpl.class);

    public MessageDigestPasswordEncoderImpl(String algorithm) throws  IllegalArgumentException{
        super(algorithm);
    }
    public MessageDigestPasswordEncoderImpl(String algorithm, boolean encodeHashAsBase64) throws IllegalArgumentException {
        super(algorithm, encodeHashAsBase64);
    }

    /**
     * @param encPass 数据库密码
     * @param rawPass 前端传送过来的密码
     * @param salt 加盐，这里忽略，暂时不引用
     * @return
     */
    @Override
    public boolean isPasswordValid(String encPass, String rawPass, Object salt) {
        String pass1 = "" + encPass;
        String pass2 = md5Util.encode(rawPass);
        boolean bool=false;
        if(pass1.equals(pass2)){
            bool=true;
        }
        return bool;
    }
}
