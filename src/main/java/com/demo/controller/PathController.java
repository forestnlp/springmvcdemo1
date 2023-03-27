package com.demo.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.ModelAndView;

@Controller
public class PathController {
    @RequestMapping("/testPathVariable/{id}/{username}")
    public String testPathVariable(@PathVariable("id") Integer id, @PathVariable("username") String username){
        System.out.println("id:"+id);
        System.out.println("username:"+username);
        System.out.println("testPathVariable1");
        ModelAndView modelAndView = new ModelAndView();
        return "attributes";
    }

    @RequestMapping("/getRequestHeader")
    public String getRequestHeader(@RequestHeader(value="Accept", required=false)String requestHeader){
        System.out.println(requestHeader);
        return "success";
    }

    @RequestMapping("/getCookie")
    public String getCookie(@CookieValue(value="JSESSIONID",required=false) String cookieValue){
        System.out.println(cookieValue);
        return "success";
    }

    @RequestMapping("/getRequestParam")
    public String getRequestParam(@RequestParam("name")String uname, @RequestParam(value="age",required=false)int age){
        System.out.println(uname+","+age);
        return "success";
    }

}
