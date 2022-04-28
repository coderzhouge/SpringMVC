package xyz.zhouge.converter.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

/**
 * @BelongsProject: SpringMVC
 * @BelongsPackage: xyz.zhouge.converter.controller
 * @CreateTime: 2022-04-09  23:37
 * @Description: TODO
 * @Version: 1.0
 * @Author：zhouge
 */

@Controller
public class Index {

    @RequestMapping("/")
    public  String index(){
        return "index";
    }

}
