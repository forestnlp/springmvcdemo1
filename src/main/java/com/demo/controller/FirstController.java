package com.demo.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
/**
 * @Author: Ma HaiYang
 * @Description: MircoMessage:Mark_7001
 */
@Controller
@RequestMapping("/go")
public class FirstController  {
    @RequestMapping("/firstController.do")
    public String firstController(){
        System.out.println("this is firstController");
        return "first";
    }
}
