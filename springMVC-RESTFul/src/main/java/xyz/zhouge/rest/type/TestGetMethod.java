package xyz.zhouge.rest.type;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.servlet.ModelAndView;

/**
 * @Description TODO
 * @Classname TestGetMethod
 * @Date 4/4/2022 12:40 PM
 * @Created by zhouge
 */
@Controller
public class TestGetMethod {

    @RequestMapping(value = "/user" ,method = RequestMethod.GET)
    public ModelAndView getAllUser(){
        ModelAndView mav = new ModelAndView();
        mav.addObject("msg","I'm transfer by get .");
        mav.setViewName("success");
        System.out.println("SELECT ALL USER");
        return mav;
    }
}


