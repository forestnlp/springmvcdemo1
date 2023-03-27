package com.demo.controller;

import com.demo.dto.Person;
import org.springframework.format.annotation.DateTimeFormat;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.Date;

@RestController
public class ReceiveDataController {
    /*
    * 使用POJO接收参数时,注意事项
    * 提交的参数名必须和POJO的属性名保持一致
    * springmvc底层通过反射给参数列表的属性赋值
    * 通过set方法设置属性值的,不是直接通过操作属性
    * POJO的属性一定要有set方法,要不然就会接收失败
    * */
    @RequestMapping("/getDataByPojo")
    //public String getDataByPojo(Date birthdate,Person p){
    public String getDataByPojo(@DateTimeFormat(pattern = "yyyy-MM-dd") Date birthdate,Person p){
        System.out.println(birthdate);
        System.out.println(p);
        return "getParamSuccess";
    }
}
