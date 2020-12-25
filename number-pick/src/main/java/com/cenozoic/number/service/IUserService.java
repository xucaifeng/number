package com.cenozoic.number.service;

import com.cenozoic.number.dto.Resp;

import javax.servlet.http.HttpServletRequest;

/**
 * <p> 
 *
 * @author xucaifeng
 * @since 2020-12-19
 **/
public interface IUserService {
    /**
     * 校验用户
     *
     * @param request
     * @param userName
     * @param password
     * @return
     */
    Resp checkUser(HttpServletRequest request, String userName, String password);
}
