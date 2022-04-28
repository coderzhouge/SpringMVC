package xyz.zhouge.rest.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

/**
 * @Description TODO
 * @Classname Index
 * @Date 4/4/2022 12:14 PM
 * @Created by zhouge
 */
@Controller
public class Index {

    /*@RequestMapping("/")
    public String index(){
        return "index";
    }*/

    @RequestMapping("/success")
    public String success(){
        return "success";
    }



}
