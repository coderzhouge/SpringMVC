package xyz.zhouge.view;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

/**
 * @Description TODO
 * @Classname IndexController
 * @Date 4/4/2022 10:07 AM
 * @Created by zhouge
 */

@Controller
public class IndexController {

    @RequestMapping("/")
    public String index(){
        return "index";
    }

   /* @RequestMapping("/success")
    public String success(){
        return "success";
    }*/
}
