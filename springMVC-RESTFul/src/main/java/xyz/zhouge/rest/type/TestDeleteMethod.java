package xyz.zhouge.rest.type;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.servlet.ModelAndView;

/**
 * @Description TODO
 * @Classname TestDeleteMethod
 * @Date 4/4/2022 2:08 PM
 * @Created by zhouge
 */
@Controller
public class TestDeleteMethod {

    @RequestMapping(value = "/user/{id}" ,method = RequestMethod.DELETE)
    public ModelAndView deleteUserById(){
        ModelAndView mav = new ModelAndView();
        mav.addObject("msg","I'm transfer from Delete ");
        mav.setViewName("success");
        return mav;
    }
}
