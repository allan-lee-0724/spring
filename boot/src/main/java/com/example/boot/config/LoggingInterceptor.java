package com.example.boot.config;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.slf4j.MDC;
import org.springframework.lang.Nullable;
import org.springframework.stereotype.Component;
import org.springframework.web.servlet.HandlerInterceptor;

@Component
public class LoggingInterceptor implements HandlerInterceptor {

    @Override
    public void afterCompletion(HttpServletRequest request, HttpServletResponse response, Object handler, @Nullable Exception ex) throws Exception {
        MDC.clear(); // this removes all key/value pairs, clearing it up for the next http request
        System.out.println("Logging Interceptor afterCompletion executed");
    }

    @Override
    public boolean preHandle(HttpServletRequest request, HttpServletResponse response, Object handler) throws Exception {
        // MDC = Mapped Diagnostic Context
        MDC.put("METHOD", request.getMethod()); // logs the verb of the http request
        MDC.put("URI", request.getRequestURI()); // logs the uri of the http request
        System.out.println("Logging Interceptor preHandle executed");

        return true;
    }
    
    

}
