package com.demo.configuration;

import com.demo.dto.User;
import org.springframework.web.servlet.HandlerInterceptor;
import org.springframework.web.servlet.ModelAndView;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

public class MyInterceptor implements HandlerInterceptor {
    @Override
    public boolean preHandle(HttpServletRequest request, HttpServletResponse response, Object handler) throws Exception {
        /*在请求到达我们定义的handler之前工作的*/
        System.out.println("MyInterceptor preHandle");
        /*设置请求和响应的乱码 */
        /* request.setCharacterEncoding("UTF-8");
        response.setCharacterEncoding("UTF-8");*/
        // 判断是否登录
//        User user =(User) request.getSession().getAttribute("user");
//        if(null == user)
//            response.sendRedirect("index.jsp");
//        return false;
        // 用户权限控制
        return true;
    }
    @Override
    public void postHandle(HttpServletRequest request, HttpServletResponse response, Object handler, ModelAndView modelAndView) throws Exception {
        System.out.println("MyInterceptor postHandle");
        /*handler 处理单元返回ModelAndView 时候进行 拦截*/
    }
    @Override
    public void afterCompletion(HttpServletRequest request, HttpServletResponse response, Object handler, Exception ex) throws Exception {
        /*
        页面渲染完毕,但是还没有给浏览器响应数据的时候
         */
        System.out.println("MyInterceptor afterCompletion");
    }
}
