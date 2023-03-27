package com.demo.exceptionhandler;

import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.servlet.ModelAndView;

//@ControllerAdvice
public class GloableExceptionHandler1 {
    //此处优先级低于局部异常处理器
    @ExceptionHandler(value ={ArithmeticException.class,NullPointerException.class} )
    public ModelAndView handelException(Exception e){
        ModelAndView mv =new ModelAndView();
        mv.setViewName("error.jsp");
        mv.addObject("msg",e);
        mv.addObject("fromhandler","GloableExceptionHandler1");
        return mv;
    }
}
