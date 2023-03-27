package com.demo.controller;

import com.demo.dto.User;
import com.demo.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.servlet.ModelAndView;

import java.nio.charset.StandardCharsets;
import java.util.List;

@Controller
public class UserController {
    @Autowired
    private UserService userService;
    @RequestMapping("login.do")
    public String login(String uname,String password){
        String view =null;
        User user = userService.findUser(uname, password);
        if(null != user){
            view ="/success.jsp";
        }else{
            view="/fail.jsp";
        }
        return view;
    }
    @ResponseBody
    @RequestMapping("findAllUser.do")
    public List<User> findAllUser(){
        return userService.findAllUser();
    }

    @RequestMapping("/testController")
    public String useRequestBody(@RequestBody(required=false) User user){
        System.out.println(user);
        return "msb";

    }

    @ResponseBody
    @RequestMapping("/testerr")
    public String testerr(){
        //int i=1/0;
        String s =null;
        byte[] bytes = s.getBytes(StandardCharsets.UTF_8);
        return "OK";
    }

    // 如果定义这个方法，那么会处理该类里的异常，优先级高
    // @ExceptionHandler(value ={ArithmeticException.class,NullPointerException.class} )
    public ModelAndView handelException(Exception e){
        ModelAndView mv =new ModelAndView();
        mv.setViewName("error.jsp");
        mv.addObject("msg",e);
        mv.addObject("fromhandler","UserController");
        return mv;
    }
}
