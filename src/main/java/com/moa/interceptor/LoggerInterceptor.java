package com.moa.interceptor;


import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;
import org.springframework.web.servlet.ModelAndView;
import org.springframework.web.servlet.handler.HandlerInterceptorAdapter;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

public class LoggerInterceptor extends HandlerInterceptorAdapter {
    protected Log log= LogFactory.getLog(LoggerInterceptor.class);

    @Override
    public boolean preHandle(HttpServletRequest request, HttpServletResponse response, Object handler) throws Exception {
        if(log.isInfoEnabled()) {
            log.info("<<<<<<<<<<<<<<<<<<<<start infoLog");
            log.info("Request URI \t : "+ request.getRequestURI());
        }
        return super.preHandle(request, response, handler);
    }

    @Override
    public void postHandle(HttpServletRequest request, HttpServletResponse response, Object handler, ModelAndView modelAndView) throws Exception {
        if(log.isInfoEnabled()) {
            log.info(">>>>>>>>>>>>>>>>>> end infoLog");
        }
        super.postHandle(request, response, handler, modelAndView);
    }
}
