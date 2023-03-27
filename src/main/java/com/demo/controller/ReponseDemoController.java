package com.demo.controller;

import com.demo.dto.Person;
import com.demo.dto.Pet;
import com.fasterxml.jackson.core.JsonProcessingException;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.servlet.ModelAndView;
import org.springframework.web.servlet.View;
import org.springframework.web.servlet.view.RedirectView;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

@Controller
public class ReponseDemoController {
    @RequestMapping("demo1")
    public void testDemo1(HttpServletRequest request, HttpServletResponse response) throws Exception {
        // 请求转发
        request.getRequestDispatcher("/forward.jsp").forward(request,response);
        // 响应重定向
        //response.sendRedirect(request.getContextPath()+"/redirect.jsp");
    }

    /*
     * 返回字符串告诉DispatcherServlet跳转的路径
     * 在路径之前放上一个forward: 关键字,就是请求转发
     * 如果路径前的关键字是forward,那么可以省略不写
     * */
    @RequestMapping("demo2")
    public String testDemo2() throws Exception {
        return "forward:/forwardPage.jsp";
        //return "/forwardPage";
    }

    /*
     * 返回字符串告诉DispatcherServlet跳转的路径
     * 在路径之前放上一个redirect: 关键字,就是重定向
     * 如果路径前的关键字是redirect,那么不可以省略
     * /表示当前项目下.这里不需要项目的上下文路径
     * */
    @RequestMapping("demo3")
    public String testDemo3() throws Exception {
        return "redirect:/redirectPage.jsp";
    }

    @RequestMapping("demo4")
    public View testDemo4(HttpServletRequest req)   {
        View  view =null;
        // 请求转发
        //view =new InternalResourceView("/forwardPage.jsp");
        // 重定向
        view=new RedirectView(req.getContextPath()+"/redirectPage.jsp");
        return view;
    }

    @RequestMapping("demo5")
    public ModelAndView testDemo5(HttpServletRequest req)   {
        ModelAndView mv=new ModelAndView();
        // 请求转发
        //mv.setViewName("forward:/forwardPage.jsp");
        //mv.setView(new InternalResourceView("/forwardPage.jsp"));
        // 重定向
        //mv.setViewName("redirect:/redirectPage.jsp");
        mv.setView(new RedirectView(req.getContextPath()+"/redirectPage.jsp"));
        return mv;
    }

    /*
     * @ResponseBody
     * 1方法的返回值不在作为界面跳转依据,而已直接作为返回的数据
     * 2将方法的返回的数据自动使用ObjectMapper转换为JSON
     */
    @ResponseBody
    @RequestMapping("testAjax")
    public Pet testAjax(Person p) throws JsonProcessingException {
        System.out.println(p);
        Pet pet =new Pet("汤姆","猫猫");
        return pet;
    }
}
