package com.ontime.interceptor;


import com.ontime.core.ActionContext;
import com.ontime.core.ApiResponse;
import com.ontime.core.AuthUser;
import com.ontime.exception.YCIllegalAccessException;
import com.ontime.utils.JsonMapper;
import org.springframework.core.annotation.AnnotationUtils;
import org.springframework.web.method.HandlerMethod;
import org.springframework.web.servlet.handler.HandlerInterceptorAdapter;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.PrintWriter;


public class AuthenticationInterceptor extends HandlerInterceptorAdapter {

    public static final String UTF8 = "UTF-8";

    @Override
    public boolean preHandle(HttpServletRequest request, HttpServletResponse response, Object handler) throws Exception {
        try {
            verify((HandlerMethod)handler);
            return true;
        }catch (YCIllegalAccessException e){
            response.setHeader("Content-type","application/json;charset=UTF-8");//向浏览器发送一个响应头，设置浏览器的解码方式为UTF-8
            response.setCharacterEncoding(UTF8);//设置Response的编码方式为UTF-8
            String json = JsonMapper.buildNonDefaultBinder().toJson(ApiResponse.Create(400,e.getMessage()));
            PrintWriter writer = response.getWriter();
            writer.write(json);
            writer.close();
        }
        return false;
    }
    private void verify(HandlerMethod handler) throws YCIllegalAccessException {
        ActionContext context = ActionContext.getActionContext();
        AuthUser user = context.currentUser();

        if(!user.isAuthorized()) throw new YCIllegalAccessException("用户未登录"); //未登录用户


    }

}
