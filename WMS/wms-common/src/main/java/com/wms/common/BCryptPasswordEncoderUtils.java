package com.wms.common;

import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;

/**
 * 配置密码加密
 */
public class BCryptPasswordEncoderUtils {

    public static BCryptPasswordEncoder bCryptPasswordEncoder =  new BCryptPasswordEncoder();

    /**
     * 密码加密
     * @param password
     * @return
     */
    public static String passwordEncoder(String password) {
        return bCryptPasswordEncoder.encode(password);
    }

    /**
     * 加密测试
     * @param args
     */
    public static void main(String[] args) {
        String password = "123456";
        String passwordEncoder = BCryptPasswordEncoderUtils.passwordEncoder(password);
        System.out.println(passwordEncoder);
    }

}
