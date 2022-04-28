package xyz.zhouge.interceptor.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

/**
 * @BelongsProject: SpringMVC
 * @BelongsPackage: xyz.zhouge.intercepter.controller
 * @CreateTime: 2022-04-12  22:41
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
