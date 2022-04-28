package xyz.zhouge.demo.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

/**
 * @BelongsProject: SpringMVC
 * @BelongsPackage: xyz.zhouge.demo.controller
 * @CreateTime: 2022-04-18  21:48
 * @Description: TODO
 * @Version: 1.0
 * @Author：zhouge
 */
@Controller
public class Index {

    @RequestMapping("/")
    public String index(){
        return "index";
    }
}
