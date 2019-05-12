package com.zhanglinchun.springboot.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import java.util.Arrays;
import java.util.Map;

@Controller
public class HelloController {

    /*@RequestMapping(value = {"/","login.html"})
    public String index(){
        return "login";
    }*/

    @ResponseBody
    @RequestMapping(value = "hello")
    public String hello(){
        return "Hello world";
    }

    @RequestMapping(value = "success")
    public String success(Map<String,Object> map){
        // 只要我们把HTML页面放在classpath:/templates/，thymeleaf就能自动渲染；
        map.put("hello","<h2>hello thymeleaf</h2>");
        map.put("users", Arrays.asList("zhangsan","lisi","wangwu"));
        return "success";
    }
}
