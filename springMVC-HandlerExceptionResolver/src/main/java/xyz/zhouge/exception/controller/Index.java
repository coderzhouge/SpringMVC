package xyz.zhouge.exception.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

/**
 * @BelongsProject: SpringMVC
 * @BelongsPackage: xyz.zhouge.exception.controller
 * @CreateTime: 2022-04-18  20:48
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
