package com.example.boot.config;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.springframework.lang.Nullable;
import org.springframework.stereotype.Component;
import org.springframework.web.servlet.HandlerInterceptor;
import org.springframework.web.servlet.ModelAndView;

/*
 * Interceptors are used to pre-process or post-process information before your regular handlers
 * (inside your controller classes) do their work. This can be useful for logging information before/after 
 * an http request is handled, or it could be used to validate a session before allowing the request to
 * be sent to its proper handler in the API.
 * 
 * WARNING: if an ExceptionHandler is triggered, you will not get the postHandle method
 */

@Component // this tells Spring to manage the class
public class BasicInterceptor implements HandlerInterceptor {
    
    @Override
    public boolean preHandle(HttpServletRequest request, HttpServletResponse response, Object handler) throws Exception {
        System.out.println("BasicInterceptor preHandle executed");
        return true;
    }


    @Override
    public void postHandle(HttpServletRequest request, HttpServletResponse response, Object handler, @Nullable ModelAndView modelAndView) throws Exception {
        System.out.println("BasicInterceptor postHandle executed");
    }


    @Override
    public void afterCompletion(HttpServletRequest request, HttpServletResponse response, Object handler, @Nullable Exception ex) throws Exception {
        System.out.println("BasicInterceptor afterCompletion executed");
    }

    

    
    
    

}
