package xyz.zhouge.maven.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
public class HelloController {

    @RequestMapping("/")//处理器的映射地址映射到指定的文件下。/ 指的是当前工程上下文，即webapp
    public String index(){
        return "index";
    }

    @RequestMapping("/target")
    public String toTarget(){
        return  "target";
    }
}
