package com.demo.exceptionhandler;

import org.springframework.context.annotation.Configuration;
import org.springframework.web.servlet.HandlerExceptionResolver;
import org.springframework.web.servlet.ModelAndView;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

@Configuration
  public class GloableException3 implements HandlerExceptionResolver {
    @Override
    public ModelAndView resolveException(HttpServletRequest httpServletRequest, HttpServletResponse httpServletResponse, Object o, Exception e) {
        ModelAndView mv = new ModelAndView();
//        if(e instanceof NullPointerException){
//                mv.setViewName("error1");
//        }
//        if(e instanceof ArithmeticException){
//                mv.setViewName("error2");
//        }
        mv.setViewName("error.jsp");
        mv.addObject("msg",e);
        return mv;
    }}
