package com.demo.controller;

import com.demo.dto.User;
import com.demo.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;

import javax.servlet.ServletContext;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;
import java.util.List;
import java.util.Map;

@Controller
public class ScopeController {
    @Autowired
    private UserService userService;
    /*
    * request,session 这两个域直接放在参数列表上即可,SpringMVC就可以给我们注入
    * ServletContext对象(application域) 不能直接放在参数列表上的
    * */
    @RequestMapping("setData")
    public String setData(HttpServletRequest req, HttpSession session){
        List<User> users = userService.findAllUser();
        // 向三个域中放入数据
        req.setAttribute("message", "reqMessage");
        req.setAttribute("users", users);
        session.setAttribute("message", "sesssionMessage");
        session.setAttribute("users", users);
        ServletContext application = req.getServletContext();
        application.setAttribute("message", "applictionMessage");
        application.setAttribute("users", users);
        // 跳转至showDataPage
        return "/showDataPage.jsp";
    }

    /*model对象addAttribute
     * 主要是对请求域传递数据进行了API上的封装
     * 降低controller和Servlet之间的耦合度
     * 重定向下,没法使用model传递域中的数据
     * model中的字符串类型的键值对信息会转换为请求参数,转发给目标组件
     * */
    @RequestMapping("setData2")
    public String setData2(Model model){
        List<User> users = userService.findAllUser();
        // 向域中放入数据
        model.addAttribute("message", "reqMessage");
        model.addAttribute("users", users);
        // 跳转至showDataPage
         return "forward:/showDataPage.jsp";
        //return "redirect:/showDataPage.jsp";
    }

    /*
     * ModelAndView
     * Model数据
     * View 视图
     * */
    @RequestMapping("setData3")
    public ModelAndView setData3(){
        ModelAndView mv=new ModelAndView();
        Map<String, Object> model = mv.getModel();
        // 向request域中放入数据
        List<User> users = userService.findAllUser();
        model.put("message", "reqMessage");
        model.put("users", users);
        // 设置视图
        mv.setViewName("forward:/showDataPage.jsp");
        //mv.setViewName("redirect:/showDataPage.jsp");
        return mv;
    }
}
