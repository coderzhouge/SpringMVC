package xyz.zhouge.rest.type;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.servlet.ModelAndView;

/**
 * @Description TODO
 * @Classname TestPostMethod
 * @Date 4/4/2022 1:16 PM
 * @Created by zhouge
 */
@Controller
public class TestPostMethod {

    @RequestMapping(value = "/user/{id}",method = RequestMethod.POST)
    public ModelAndView getUserById(String id,String username,String password){
        ModelAndView mav = new ModelAndView();
        mav.addObject("msg","I'm transfer from Post .");
        mav.setViewName("success");
        System.out.println("select user by id username=>"+username+",password=>"+password+",id=>"+id);
        return  mav;
    }
}
