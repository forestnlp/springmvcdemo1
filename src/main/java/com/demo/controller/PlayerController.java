package com.demo.controller;

import com.demo.dto.Player;
import com.demo.service.impl.PlayerService;
import org.apache.commons.io.IOUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import javax.servlet.ServletOutputStream;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;
import java.io.InputStream;
import java.net.URL;
import java.util.List;

@Controller
public class PlayerController  {
    @Autowired
    private PlayerService playerService;
    @RequestMapping("addPlayer")
    public String addPlayer(Player player){
        // 调用服务层方法,将数据保存进入数据库
        playerService.addPlayer(player);
        // 页面跳转至player信息展示页
        return "redirect:/success.jsp";
    }

    @RequestMapping("getAllPlayer")
    @ResponseBody
    public List<Player> getAllPlayer(){
        return playerService.getAllPlayer();
    }

    @RequestMapping("fileDownload.do")
    public void fileDownLoad(String photo, String filetype, HttpServletResponse response, HttpServletRequest request) throws IOException {
        // 设置响应头
        // 告诉浏览器要将数据保存到磁盘上,不在浏览器上直接解析
        response.setHeader("Content-Disposition", "attachment;filename="+photo);
        // 告诉浏览下载的文件类型
        response.setContentType(filetype);
        // 获取一个文件的输入流
        String filePath=request.getServletContext().getRealPath("/upload/");
        File file = new File(filePath+photo);
        System.out.println(file.getAbsoluteFile()+","+file.exists());
        InputStream inputStream = new FileInputStream(file);
        // 获取一个指向浏览器的输出流
        ServletOutputStream outputStream = response.getOutputStream();
        // 向浏览器响应文件即可
        IOUtils.copy(inputStream, outputStream);
    }
}
