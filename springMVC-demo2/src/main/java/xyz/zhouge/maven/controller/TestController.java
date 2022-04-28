package xyz.zhouge.maven.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
public class TestController {

    /*
    * @RequestMapping("/") 代表请求上下文路径
    * */
    @RequestMapping("/")
    public String index(){
        return "index";
    }

}
