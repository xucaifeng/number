package com.cenozoic.number.interceptor;

import com.alibaba.fastjson.JSON;
import com.cenozoic.number.annotation.PassToken;
import com.cenozoic.number.constant.Constant;
import com.cenozoic.number.dto.Resp;
import com.cenozoic.number.entity.User;
import org.springframework.stereotype.Component;
import org.springframework.web.method.HandlerMethod;
import org.springframework.web.servlet.HandlerInterceptor;
import org.springframework.web.servlet.ModelAndView;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.lang.reflect.Method;

/**
 * <p> 权限拦截器
 *
 * @author xucaifeng
 * @since 2020-12-21
 **/
@Component
public class AuthInterceptor implements HandlerInterceptor {

    @Override
    public boolean preHandle(HttpServletRequest request, HttpServletResponse response, Object handler) throws Exception {

        // 如果不是映射到方法直接放行
        if(!(handler instanceof HandlerMethod)){
            return true;
        }
        HandlerMethod handlerMethod = (HandlerMethod) handler;
        Method method = handlerMethod.getMethod();
        // PassToken注释，跳过认证
        if (method.isAnnotationPresent(PassToken.class)) {
            PassToken passToken = method.getAnnotation(PassToken.class);
            if (passToken.required()) {
                return true;
            }
        }

        User user = (User) request.getSession().getAttribute("user");
        if (user == null) {
            Resp resp = Resp.fail(Constant.RespStatus.LOGOUT.getCode(), "登陆过期，请重新登陆");
            response.setHeader("Pragma","No-cache");
            response.setHeader("Cache-Control","no-cache");
            response.setDateHeader("Expires", -10);
            response.setContentType("text/plain;charset=utf-8");
            response.getWriter().write(JSON.toJSONString(resp));
            return false;
        }

        return true;
    }

    @Override
    public void postHandle(HttpServletRequest request, HttpServletResponse response, Object handler, ModelAndView modelAndView) throws Exception {

    }

    @Override
    public void afterCompletion(HttpServletRequest request, HttpServletResponse response, Object handler, Exception ex) throws Exception {

    }
}
