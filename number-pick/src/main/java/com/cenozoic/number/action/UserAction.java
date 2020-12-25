package com.cenozoic.number.action;

import com.cenozoic.number.dto.Resp;
import com.cenozoic.number.service.IUserService;
import com.cenozoic.number.util.ParamUtil;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

import javax.servlet.http.HttpServletRequest;

/**
 * <p> 
 *
 * @author xucaifeng
 * @since 2020-12-19
 **/
@Slf4j
@RestController
@RequestMapping("user")
public class UserAction {

    @Autowired
    IUserService userService;

    /**
     * 登陆
     * @param request
     * @return
     */
    @ResponseBody
    @RequestMapping("login")
    public Resp login(HttpServletRequest request) {
        log.info("login_reqParams={}", ParamUtil.getInputParam(request));
        String userName = request.getParameter("userName");
        String password = request.getParameter("password");

        if (ParamUtil.isEmpty(userName) || ParamUtil.isEmpty(password)) {
            return Resp.paramError();
        }

        return userService.checkUser(request, userName, password);

    }


    /**
     * 退出登陆
     * @param request
     * @return
     */
    @RequestMapping("logout")
    public Resp logout(HttpServletRequest request) {
        log.info("logout_reqParams={}", ParamUtil.getInputParam(request));
        request.getSession().removeAttribute("user");
        return Resp.success();
    }


}
