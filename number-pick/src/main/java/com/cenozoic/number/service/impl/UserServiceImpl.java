package com.cenozoic.number.service.impl;

import com.cenozoic.number.dao.UserMapper;
import com.cenozoic.number.dto.Resp;
import com.cenozoic.number.entity.User;
import com.cenozoic.number.service.IUserService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import javax.servlet.http.HttpServletRequest;

/**
 * <p> 
 *
 * @author xucaifeng
 * @since 2020-12-19
 **/
@Service
@Slf4j
public class UserServiceImpl implements IUserService {

    @Autowired
    UserMapper userMapper;


    @Override
    public Resp checkUser(HttpServletRequest request, String userName, String password) {
        try {
            User user = new User();
            user.setUserName(userName);
            user = userMapper.selectOne(user);

            if (user != null && password.equals(user.getPassword())) {
                user.setPassword("");
                request.getSession().setAttribute("user", user);
                return Resp.success(user);
            }
            return Resp.fail("账户名或密码错误");
        } catch (Exception e) {
            log.info("checkUser_e="+e.getMessage(), e);
        }
        return Resp.fail("系统繁忙，请稍后再试");
    }
}
