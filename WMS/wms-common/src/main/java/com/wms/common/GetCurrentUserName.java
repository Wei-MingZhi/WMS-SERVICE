package com.wms.common;

import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.security.core.userdetails.UserDetails;

/**
 * 获取当前登录用户信息
 */
public class GetCurrentUserName {

    /**
     * 获取当前登录用户信息
     * @param user
     * @return
     */
    public static UserDetails getCurrentUserUserName(){
        return  (UserDetails) SecurityContextHolder.getContext().getAuthentication().getPrincipal();
    }

}
