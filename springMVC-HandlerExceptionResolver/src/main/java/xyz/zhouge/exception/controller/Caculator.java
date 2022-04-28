package xyz.zhouge.exception.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

/**
 * @BelongsProject: SpringMVC
 * @BelongsPackage: xyz.zhouge.exception.controller
 * @CreateTime: 2022-04-18  21:13
 * @Description: TODO
 * @Version: 1.0
 * @Author：zhouge
 */
@Controller
public class Caculator {

    @RequestMapping("/testArithmeticException")
    public String testArithmeticException(){
        System.out.println(1/0);
        return "success";
    }


}
