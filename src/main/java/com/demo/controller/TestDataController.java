package com.demo.controller;

import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

@RestController
public class TestDataController {
    /*紧耦合方式参数注入
    * 使用传统的HttpServletRequest对象获取参数  javax.servlet
    * */
    @RequestMapping("/getParamByRequest.do")
    public String getParam1(HttpServletRequest req, HttpServletResponse resp){
        String username = req.getParameter("username");
        String password = req.getParameter("password");
        System.out.println("username:"+username+"   password:"+password);
        return "getParamSuccess";
    }
    /*解耦合方式参数注入
    * HttpServletRequest对象获取参数 通过SpringMVC框架功能,自动转换参数
    * 处理单元参数列表中参数名必须和请求中的参数名一致
                                        * 如不一致,可以通过@RequestParma注解进行转换
    * */
    @RequestMapping("/getParamByArgName.do")
    public String getParam2(String username,@RequestParam("pwd") int password){
        System.out.println("username:"+username+"   password:"+password);
        return "getParamSuccess";
    }
}
