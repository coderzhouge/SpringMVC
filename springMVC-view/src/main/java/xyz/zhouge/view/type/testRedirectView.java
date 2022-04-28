package xyz.zhouge.view.type;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;

/**
 * @Description TODO
 * @Classname testRedirectView
 * @Date 4/4/2022 10:56 AM
 * @Created by zhouge
 */
@Controller
public class testRedirectView {

    @RequestMapping("/testRedirectView")
    public ModelAndView testRedirectView(){
        ModelAndView mav = new ModelAndView();
        mav.addObject("msg","I'm resolved by RedirectViewResolver .");
        mav.setViewName("redirect:success");
        return mav;
    }
}
