package com.yi_blog.demo.config;

import org.springframework.web.servlet.HandlerInterceptor;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

public class AdminInterceptor implements HandlerInterceptor {
    @Override
    public boolean preHandle(HttpServletRequest request, HttpServletResponse response, Object handler) throws Exception {
        try{
            String username = (String)request.getSession().getAttribute("username");
             if(username != null){
                return true;
            }
            response.sendRedirect(request.getContextPath()+"/login");
        }catch (Exception e){
            e.printStackTrace();
        }
        return false;
    }

}
