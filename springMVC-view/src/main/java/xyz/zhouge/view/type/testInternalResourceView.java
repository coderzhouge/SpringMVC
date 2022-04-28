package xyz.zhouge.view.type;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;

/**
 * @Description TODO
 * @Classname testInternalResourceView
 * @Date 4/4/2022 10:48 AM
 * @Created by zhouge
 */
@Controller
public class testInternalResourceView {

    @RequestMapping("/testInternalResourceView")
    public ModelAndView testInternalResourceView(){
        ModelAndView mav = new ModelAndView();
        mav.addObject("msg","I'm resolved by InternalResourceViewResolver. ");
        mav.setViewName("forward:/success");
        return mav;
    }
}
