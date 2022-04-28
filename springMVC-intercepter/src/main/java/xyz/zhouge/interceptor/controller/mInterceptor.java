package xyz.zhouge.interceptor.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

/**
 * @BelongsProject: SpringMVC
 * @BelongsPackage: xyz.zhouge.interceptor.controller
 * @CreateTime: 2022-04-12  22:56
 * @Description: TODO
 * @Version: 1.0
 * @Author：zhouge
 */
@Controller
public class mInterceptor {

    @RequestMapping("/testInterceptor1")
    public String testInterceptor1(){
        return  "success";
    }
}
