package xyz.zhouge.rest.type;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.servlet.ModelAndView;

/**
 * @Description TODO
 * @Classname TestPutMethod
 * @Date 4/4/2022 2:01 PM
 * @Created by zhouge
 */
@Controller
public class TestPutMethod {

    /**
     *  Method Not Allowed. Request method 'POST' not supported => HiddenHttpMethodFilter
     *
     * @return
     */
    @RequestMapping(value = "/user",method = RequestMethod.PUT)
    public ModelAndView insertUser(){
        ModelAndView mav = new ModelAndView();
        mav.addObject("msg","I'm transfer from Put .");
        mav.setViewName("success");
        System.out.println("insert user ");
        return mav;
    }
}
